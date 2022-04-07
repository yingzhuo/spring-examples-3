--[[
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
作者: 应卓

参数:
    1 -> 商品ID
    2 -> 用户ID

返回值:
    0 -> 秒杀成功
    1 -> 秒杀已结束 (库存已到0)
    2 -> 不可重复秒杀
    -1 -> 商品ID不存在

注意事项:
    集群模式时，要求在同一个LUA脚本里读写的所有key都在同一个节点，为了此要求必须使用hash-tags
    https://redis.io/docs/reference/cluster-spec/#hash-tags
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
]]

local prodId = tonumber(ARGV[1])
local userId = ARGV[2]

local prodRedisKey = string.format("prod:{%d}:inv", prodId)
local userRedisKey = string.format("user:{%d}:winner", prodId)

if redis.call("EXISTS", prodRedisKey) == 0 then
    return -1
end

-- 判断是否重复秒杀
if tonumber(redis.call("SISMEMBER", userRedisKey, userId)) == 1 then
    return 2
end

-- 获取当前库存
local currentEnv = tonumber(redis.call("GET", prodRedisKey))

-- 判断是否秒杀活动已结束
if currentEnv <= 0 then
    return 1
end

-- 减库存并添加秒杀成功记录
redis.call("DECR", prodRedisKey)
redis.call("SADD", userRedisKey, userId)

return 0

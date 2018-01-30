/*
 * Copyright 2016-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lambdaworks.redis.cluster.pubsub;

import com.lambdaworks.redis.cluster.models.partitions.RedisClusterNode;

/**
 * Convenience adapter with an empty implementation of all {@link RedisClusterPubSubListener} callback methods.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 4.4
 */
public class RedisClusterPubSubAdapter<K, V> implements RedisClusterPubSubListener<K, V> {

    @Override
    public void message(RedisClusterNode node, K channel, V message) {
        // empty adapter method
    }

    @Override
    public void message(RedisClusterNode node, K pattern, K channel, V message) {
        // empty adapter method
    }

    @Override
    public void subscribed(RedisClusterNode node, K channel, long count) {
        // empty adapter method
    }

    @Override
    public void psubscribed(RedisClusterNode node, K pattern, long count) {
        // empty adapter method
    }

    @Override
    public void unsubscribed(RedisClusterNode node, K channel, long count) {
        // empty adapter method
    }

    @Override
    public void punsubscribed(RedisClusterNode node, K pattern, long count) {
        // empty adapter method
    }
}

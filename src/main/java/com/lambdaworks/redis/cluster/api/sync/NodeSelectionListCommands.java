/*
 * Copyright 2011-2018 the original author or authors.
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
package com.lambdaworks.redis.cluster.api.sync;

import java.util.List;

import com.lambdaworks.redis.KeyValue;
import com.lambdaworks.redis.output.ValueStreamingChannel;

/**
 * Synchronous executed commands on a node selection for Lists.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 4.0
 * @generated by com.lambdaworks.apigenerator.CreateSyncNodeSelectionClusterApi
 */
public interface NodeSelectionListCommands<K, V> {

    /**
     * Remove and get the first element in a list, or block until one is available.
     *
     * @param timeout the timeout in seconds
     * @param keys the keys
     * @return KeyValue&lt;K,V&gt; array-reply specifically:
     *
     *         A {@literal null} multi-bulk when no element could be popped and the timeout expired. A two-element multi-bulk
     *         with the first element being the name of the key where an element was popped and the second element being the
     *         value of the popped element.
     */
    Executions<KeyValue<K, V>> blpop(long timeout, K... keys);

    /**
     * Remove and get the last element in a list, or block until one is available.
     *
     * @param timeout the timeout in seconds
     * @param keys the keys
     * @return KeyValue&lt;K,V&gt; array-reply specifically:
     *
     *         A {@literal null} multi-bulk when no element could be popped and the timeout expired. A two-element multi-bulk
     *         with the first element being the name of the key where an element was popped and the second element being the
     *         value of the popped element.
     */
    Executions<KeyValue<K, V>> brpop(long timeout, K... keys);

    /**
     * Pop a value from a list, push it to another list and return it; or block until one is available.
     *
     * @param timeout the timeout in seconds
     * @param source the source key
     * @param destination the destination type: key
     * @return V bulk-string-reply the element being popped from {@code source} and pushed to {@code destination}. If
     *         {@code timeout} is reached, a
     */
    Executions<V> brpoplpush(long timeout, K source, K destination);

    /**
     * Get an element from a list by its index.
     *
     * @param key the key
     * @param index the index type: long
     * @return V bulk-string-reply the requested element, or {@literal null} when {@code index} is out of range.
     */
    Executions<V> lindex(K key, long index);

    /**
     * Insert an element before or after another element in a list.
     *
     * @param key the key
     * @param before the before
     * @param pivot the pivot
     * @param value the value
     * @return Long integer-reply the length of the list after the insert operation, or {@code -1} when the value {@code pivot}
     *         was not found.
     */
    Executions<Long> linsert(K key, boolean before, V pivot, V value);

    /**
     * Get the length of a list.
     *
     * @param key the key
     * @return Long integer-reply the length of the list at {@code key}.
     */
    Executions<Long> llen(K key);

    /**
     * Remove and get the first element in a list.
     *
     * @param key the key
     * @return V bulk-string-reply the value of the first element, or {@literal null} when {@code key} does not exist.
     */
    Executions<V> lpop(K key);

    /**
     * Prepend one or multiple values to a list.
     *
     * @param key the key
     * @param values the value
     * @return Long integer-reply the length of the list after the push operations.
     */
    Executions<Long> lpush(K key, V... values);

    /**
     * Prepend a value to a list, only if the list exists.
     *
     * @param key the key
     * @param value the value
     * @return Long integer-reply the length of the list after the push operation.
     * @deprecated Use {@link #lpushx(Object, Object[])}
     */
    @Deprecated
    Executions<Long> lpushx(K key, V value);

    /**
     * Prepend values to a list, only if the list exists.
     *
     * @param key the key
     * @param values the values
     * @return Long integer-reply the length of the list after the push operation.
     */
    Executions<Long> lpushx(K key, V... values);

    /**
     * Get a range of elements from a list.
     *
     * @param key the key
     * @param start the start type: long
     * @param stop the stop type: long
     * @return List&lt;V&gt; array-reply list of elements in the specified range.
     */
    Executions<List<V>> lrange(K key, long start, long stop);

    /**
     * Get a range of elements from a list.
     *
     * @param channel the channel
     * @param key the key
     * @param start the start type: long
     * @param stop the stop type: long
     * @return Long count of elements in the specified range.
     */
    Executions<Long> lrange(ValueStreamingChannel<V> channel, K key, long start, long stop);

    /**
     * Remove elements from a list.
     *
     * @param key the key
     * @param count the count type: long
     * @param value the value
     * @return Long integer-reply the number of removed elements.
     */
    Executions<Long> lrem(K key, long count, V value);

    /**
     * Set the value of an element in a list by its index.
     *
     * @param key the key
     * @param index the index type: long
     * @param value the value
     * @return String simple-string-reply
     */
    Executions<String> lset(K key, long index, V value);

    /**
     * Trim a list to the specified range.
     *
     * @param key the key
     * @param start the start type: long
     * @param stop the stop type: long
     * @return String simple-string-reply
     */
    Executions<String> ltrim(K key, long start, long stop);

    /**
     * Remove and get the last element in a list.
     *
     * @param key the key
     * @return V bulk-string-reply the value of the last element, or {@literal null} when {@code key} does not exist.
     */
    Executions<V> rpop(K key);

    /**
     * Remove the last element in a list, append it to another list and return it.
     *
     * @param source the source key
     * @param destination the destination type: key
     * @return V bulk-string-reply the element being popped and pushed.
     */
    Executions<V> rpoplpush(K source, K destination);

    /**
     * Append one or multiple values to a list.
     *
     * @param key the key
     * @param values the value
     * @return Long integer-reply the length of the list after the push operation.
     */
    Executions<Long> rpush(K key, V... values);

    /**
     * Append a value to a list, only if the list exists.
     *
     * @param key the key
     * @param value the value
     * @return Long integer-reply the length of the list after the push operation.
     * @deprecated Use {@link #rpushx(java.lang.Object, java.lang.Object[])}
     */
    @Deprecated
    Executions<Long> rpushx(K key, V value);

    /**
     * Append values to a list, only if the list exists.
     *
     * @param key the key
     * @param values the values
     * @return Long integer-reply the length of the list after the push operation.
     */
    Executions<Long> rpushx(K key, V... values);
}

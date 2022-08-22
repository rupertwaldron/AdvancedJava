/*
 * The MIT License
 *
 *  Copyright (c) 2020, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package com.ruppyrup.reflection.rulesengine.api;

import com.ruppyrup.reflection.rulesengine.core.RuleProxy;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class encapsulates a set of rules and represents a rules namespace.
 * Rules must have a unique name within a rules namespace.
 * 
 * Rules will be compared to each other based on {@link EngineRule#compareTo(Object)}
 * method, so {@link EngineRule}'s implementations are expected to correctly implement
 * {@code compareTo} to ensure unique rule names within a single namespace.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public class Rules implements Iterable<EngineRule> {

    private Set<EngineRule> engineRules = new TreeSet<>();

    /**
     * Create a new {@link Rules} object.
     *
     * @param engineRules to register
     */
    public Rules(Set<EngineRule> engineRules) {
        this.engineRules = new TreeSet<>(engineRules);
    }

    /**
     * Create a new {@link Rules} object.
     *
     * @param engineRules to register
     */
    public Rules(EngineRule... engineRules) {
        Collections.addAll(this.engineRules, engineRules);
    }

    /**
     * Create a new {@link Rules} object.
     *
     * @param rules to register
     */
    public Rules(Object... rules) {
        this.register(rules);
    }

    /**
     * Register one or more new rules.
     *
     * @param rules to register, must not be null
     */
    public void register(Object... rules) {
        Objects.requireNonNull(rules);
        for (Object rule : rules) {
            Objects.requireNonNull(rule);
            this.engineRules.add(RuleProxy.asRule(rule));
        }
    }

    /**
     * Unregister one or more rules.
     *
     * @param rules to unregister, must not be null
     */
    public void unregister(Object... rules) {
        Objects.requireNonNull(rules);
        for (Object rule : rules) {
            Objects.requireNonNull(rule);
            this.engineRules.remove(RuleProxy.asRule(rule));
        }
    }

    /**
     * Unregister a rule by name.
     *
     * @param ruleName name of the rule to unregister, must not be null
     */
    public void unregister(final String ruleName) {
        Objects.requireNonNull(ruleName);
        EngineRule engineRule = findRuleByName(ruleName);
        if (engineRule != null) {
            unregister(engineRule);
        }
    }

    /**
     * Check if the rule set is empty.
     *
     * @return true if the rule set is empty, false otherwise
     */
    public boolean isEmpty() {
        return engineRules.isEmpty();
    }

    /**
     * Clear rules.
     */
    public void clear() {
        engineRules.clear();
    }

    /**
     * Return how many rules are currently registered.
     *
     * @return the number of rules currently registered
     */
    public int size() {
        return engineRules.size();
    }

    /**
     * Return an iterator on the rules set. It is not intended to remove rules
     * using this iterator.
     * @return an iterator on the rules set
     */
    @Override
    public Iterator<EngineRule> iterator() {
        return engineRules.iterator();
    }

    private EngineRule findRuleByName(String ruleName) {
        return engineRules.stream()
                .filter(engineRule -> engineRule.getName().equalsIgnoreCase(ruleName))
                .findFirst()
                .orElse(null);
    }
}

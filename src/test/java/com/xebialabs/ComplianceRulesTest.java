package com.xebialabs;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplianceRulesTest {

    private ComplianceRules complianceRules = new ComplianceRules();

    @Test
    public void compliant() {
        assertTrue(complianceRules.compliant("I", "V"));
        assertTrue(complianceRules.compliant("I", "X"));
        assertTrue(complianceRules.compliant("X", "L"));
        assertTrue(complianceRules.compliant("X", "C"));
        assertFalse(complianceRules.compliant("I", "L"));
        assertFalse(complianceRules.compliant("I", "C"));
        assertFalse(complianceRules.compliant("X", "V"));
        assertFalse(complianceRules.compliant("X", "X"));
    }
}
package demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculates the discount for an order based on the customer type.
 * Placeholder code for the SATD Radar usability study demo pull request.
 */
public class DiscountCalculator {

    // Discount rates by customer type, as a fraction of the order total.
    private final Map<String, Double> rates = new HashMap<>();

    public DiscountCalculator() {
        rates.put("regular", 0.0);
        rates.put("member", 0.05);
        // TODO: this is a hack, load the rates from a config file instead of hard-coding them
        rates.put("staff", 0.20);
    }

    /**
     * Returns the discount amount for the given order total and customer type.
     */
    public double discountFor(double orderTotal, String customerType) {
        // Unknown customer types get no discount.
        double rate = rates.getOrDefault(customerType, 0.0);

        // FIXME: rounding is wrong for very large totals, fix this before release
        return Math.round(orderTotal * rate * 100) / 100.0;
    }

    /**
     * Returns true if the customer type is one we know about.
     */
    public boolean isKnownType(String customerType) {
        // Not sure this check is enough, quick workaround until we have proper validation
        return customerType != null && rates.containsKey(customerType);
    }
}

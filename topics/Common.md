### How to know when to use int, long, double based on the constraints

| Common constraint                           | Usually safe type | Why                                        |
| ------------------------------------------- | ----------------- | ------------------------------------------ |
| `n ≤ 10³`                                   | `int`             | All operations small                       |
| `n ≤ 10⁵`                                   | `int` or `long`   | Safe if not multiplying large values       |
| `n ≤ 10⁹`                                   | `long`            | Sums or multiplications can overflow `int` |
| Values up to `10⁵` and you multiply them    | `long`            | Because 10⁵ × 10⁵ = 10¹⁰ > int range       |
| Values up to `10⁹` and you add many of them | `long`            | Because sum of 10⁵ numbers × 10⁹ = 10¹⁴    |
| Division, square root, or percentage        | `double`          | Needs fractional precision                 |
| Coordinate geometry / Euclidean distance    | `double`          | Involves √ and decimal fractions           |

Are decimals involved?
    └─► YES → double
    └─► NO → check magnitude
         ├─ any value/product/sum can exceed ~2×10⁹ ? → long
         └─ else → int



### What is the modulo value for java, and how to use it while returning result (if mentioned in question)

1e3  = 1000
1e5  = 100000
1e9  = 1000000000
1e9+7 = 1000000007

static final int MOD = 1000000007; // preferred
long mod = (long) 1e9 + 7; // gives 1000000007

Example use
```
class Solution {
    static final int MOD = 1000000007;

    public int sumArray(int[] nums) {
        long sum = 0;
        for (int n : nums) {
            sum = (sum + n) % MOD;
        }
        return (int) sum; // cast back to int before returning
    }
}
```


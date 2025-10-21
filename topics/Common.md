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


### what is the modulo value for java, and how to use it while returning result (if mentioned in question)

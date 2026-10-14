# Core Java for the Impatient

Original practice exercises for Chapter 1 of Cay S. Horstmann's *Core Java for
the Impatient*: 12 tested exercises and four optional explorations. The book's
own exercises remain the baseline. See [the Chapter 1 specification](docs/ch01.md)
for statements, coverage, and notes questions.

Requires a JDK that supports Java release 24 (JDK 24 or 25). Maven 3.9.9 is
downloaded automatically by the wrapper on first use, along with dependencies.
No global Maven installation is needed.

```sh
./mvnw test                             # learner stubs; fails until solved
./mvnw -Pref test                       # reference solutions; must pass
./mvnw test -Dtest=ch01.ex03.Ex03Test    # one exercise
./mvnw test -DexcludedGroups=stretch    # skip the optional Ex09 stretch
```

On Windows, replace `./mvnw` with `.\mvnw.cmd`; for example:

```powershell
.\mvnw.cmd test
.\mvnw.cmd -Pref test
.\mvnw.cmd test -Dtest=ch01.ex03.Ex03Test
.\mvnw.cmd test -DexcludedGroups=stretch
```

Work in `src/main/java/ch01/exNN/ExNN.java`. Each file contains the complete
statement and blank `MY NOTES`; replace its TODO method bodies with your work.
Tests are in `src/test/java`. Reference implementations are in `src/ref/java`
and are selected only by `-Pref`; leave those files unopened while learning.
They are ordinary files, not access-controlled secrets. Both source sets use
the same packages and public methods, but compile separately into
`target/learner` and `target/ref`, so switching profiles needs no `clean`.

Every learner test initially errors with `UnsupportedOperationException: TODO`.
Each test has a timeout; Ex09 is tagged `stretch`. Randomized tests use fixed
seeds. Constraints described as self-policed remain your responsibility.

Ex01–Ex12 take about 6–7 hours total, including the optional 75-minute Ex09.
Explorations take about 2–3 additional hours and have no tests. Write a prediction
in their notes before running an experiment; record shell commands and timings
there too. They live in `src/main/java/ch01/explore` and contain no experiments
yet. To compile and launch one after writing it:

```sh
./mvnw compile
java -cp target/learner/classes ch01.explore.Explore01
```

The optional Word guess capstone is deferred. No book file is included.

Spec corrections: Explore03's source-launch filename is `Ex10.java`, matching
its mini grep task. Ex04's two truncation expectations were corrected to contain
the requested 13 and 12 code points. The single-exercise selector names its test
class explicitly. See the specification's correction log;
no other supplied expected values or statistical bounds were changed.

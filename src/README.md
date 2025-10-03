# DAA Assignment 2 – Boyer-Moore Majority Vote

## 📌 Overview
This project implements the **Boyer–Moore Majority Vote Algorithm** for detecting the majority element in an integer array (if it exists).  
The implementation is extended with:
- Performance tracking (runtime, comparisons, memory allocations).
- CLI benchmarking tool.
- Comprehensive unit tests.

---

## 📌 Description
This project implements the **Boyer-Moore Majority Vote Algorithm**  
(finds the element that appears more than `n/2` times in an array).  
It includes:
- The algorithm (`algorithms/BoyerMoore.java`)
- Performance tracker (`metrics/PerformanceTracker.java`)
- Benchmark runner (`cli/BenchmarkRunner.java`)
- Unit tests with JUnit5 (`algorithms/BoyerMooreTest.java`)

---

## 📂 Project Structure


Features:
- **Algorithm (`algorithms/BoyerMoore.java`)**: Static method `findMajority(int[], PerformanceTracker)` returning `Optional<Integer>`.
- **Performance Tracker (`metrics/PerformanceTracker.java`)**: Tracks comparisons, memory allocations, array accesses, and execution time.
- **Benchmark Runner (`cli/BenchmarkRunner.java`)**: Command-line tool to generate test data, run the algorithm, and print metrics in CSV format.
- **Unit Tests (`algorithms/BoyerMooreTest.java`)**: Implemented with JUnit 5.

---

## ⚙️ Requirements
- **Java 17+**
- **Maven 3.8+**

---

## ▶️ How to Run

### 1. Compile and run tests
```bash
mvn clean test
mvn -q exec:java -Dexec.mainClass="cli.BenchmarkRunner" -Dexec.args="1000 3 random"
mvn -q exec:java -Dexec.mainClass="cli.BenchmarkRunner" -Dexec.args="20 2 random"
mvn test

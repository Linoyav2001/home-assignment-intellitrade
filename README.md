# Home Assignment

**Author:** Linoy Avraham

This repository contains the implementation of the selected home assignment tasks. The project is built using **Java 21** (or compatible) with **Gradle** for dependency management, and **JUnit 5** for testing. Task 8 is implemented as a standalone zero-setup web application.

## How to Run the Tests

You can run the test suite using your IDE's built-in Test Explorer (e.g., VS Code or IntelliJ), or via the command line using Gradle:

```bash
./gradlew test
```

## Task 3: Raw HTTP Sockets

[**File:** `Task3.java`](./src/main/java/Task3.java) | [**Tests:** `Task3Test.java`](./src/test/java/Task3Test.java)

**Description:** Fetching HTML content from `www.google.com` using raw network sockets without external HTTP libraries.

**Design Decisions & Trade-offs:**

- **Low-Level Protocol Handling:** Bypassing `HttpURLConnection` or modern `HttpClient` required manually constructing the HTTP/1.1 GET request headers and manually parsing the response to separate the HTTP headers from the HTML body (looking for the `\r\n\r\n` delimiter).
- **Resource Management:** I used the `try-with-resources` statement for the `Socket`, `PrintWriter`, and `BufferedReader`. This guarantees proper resource cleanup and helps prevent resource leaks even if the network connection drops unexpectedly.

## Task 5: Thread-Safe Counter

[**File:** `Task5.java`](./src/main/java/Task5.java) | [**Tests:** `Task5Test.java`](./src/test/java/Task5Test.java)

**Description:** A thread-safe counter supporting increment, decrement, and get operations.

**Design Decisions & Trade-offs:**

- **Lock-Free Concurrency:** Instead of using the `synchronized` keyword or `ReentrantLock`, I utilized `AtomicInteger`.
- **Trade-off:** `AtomicInteger` uses atomic compare-and-set operations to support thread-safe updates without explicit locks. This can reduce lock contention under high concurrency, although it does not guarantee better performance in every scenario. The test file demonstrates thread safety with 100 threads executing 1,000 increments simultaneously.

## Task 6: Array Intersection

[**File:** `Task6.java`](./src/main/java/Task6.java) | [**Tests:** `Task6Test.java`](./src/test/java/Task6Test.java)

**Description:** An algorithm to find the intersection of two integer arrays.

**Design Decisions & Trade-offs:**

- **Algorithm Choice:** I chose a `HashSet`-based approach. By storing the elements of the first array in a Set, we achieve an **average time complexity of O(N + M)**, where N and M are the lengths of the arrays.
- **Trade-off (Space vs. Time & Worst-Case):** While this approach provides excellent average-case performance, it requires O(N) extra space. Additionally, relying on hashing means the worst-case time complexity can theoretically degrade due to hash collisions.
- **Alternatives Considered:** A naive approach using nested loops takes O(N * M) time but uses O(1) auxiliary space. Another alternative is sorting both arrays, which takes O(N log N + M log M) time and avoids hash collision risks, but modifies the original arrays unless copies are sorted. I prioritized average-case execution speed over memory footprint, as O(N) extra space is generally an acceptable trade-off for a significant practical speedup.

## Task 8: Dynamic FizzBuzz GUI

[**File:** `index.html`](./index.html) | **Live Demo:** [https://dynamic-fizzbuzz.netlify.app/](https://dynamic-fizzbuzz.netlify.app/)

**Description:** A dynamic, real-time FizzBuzz generator UI.

**Design Decisions & Trade-offs:**

- **Architecture (Zero-Setup):** While I could have built this using a modern framework like React or Vue, I opted for a single-file Vanilla JavaScript and HTML implementation using Bootstrap 5 via CDN.
- **Trade-off:** The lack of a framework means manual DOM manipulation. However, the main benefit is a frictionless review process. The reviewer can simply open the HTML file in a browser to test it immediately without needing `npm install` or a build process.
- **Performance:** To handle large numbers efficiently, the JavaScript builds a single HTML string in memory and injects it into the DOM via `innerHTML` in one operation, reducing repeated DOM updates as the user types.
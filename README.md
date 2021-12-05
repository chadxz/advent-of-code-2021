# Advent of Code 2021

```
         |                                                                       
        -+-                      ,--.                          ,--.             
         A             ,--,--. ,-|  |,--.  ,--.,---. ,--,--, ,-'  '-.           
        /=\           ' ,-.  |' .-. | \  `'  /| .-. :|      \'-.  .-'           
      i/ O \i         \ '-'  |\ `-' |  \    / \   --.|  ||  |  |  |             
      /=====\          `--`--' `---'    `--'   `----'`--''--'  `--'             
      /  i  \                 ,---.                                             
    i/ O * O \i        ,---. /  .-'                                             
    /=========\       | .-. ||  `-,                                             
    /  *   *  \       ' '-' '|  .-'                                             
  i/ O   i   O \i      `---' `--'     ,--.            ,---.   ,--.  ,---.  ,--. 
  /=============\      ,---. ,---.  ,-|  | ,---.     '.-.  \ /    \'.-.  \/   | 
  /  O   i   O  \     | .--'| .-. |' .-. || .-. :     .-' .'|  ()  |.-' .'`|  | 
i/ *   O   O   * \i   \ `--.' '-' '\ `-' |\   --.    /   '-. \    //   '-. |  | 
/=================\    `---' `---'  `---'  `----'    '-----'  `--' '-----' `--' 
       |___|                                                                     
```

There's no way I'm going to be able to do all the exercises, but I thought I'd
use the opportunity to learn more about Bazel and Scala.

### Setup

* Install bazelisk. `brew install bazelisk` on mac.
* `bazel build //...` in the top-level directory of the project

### Running

```
bazel run //src/main/scala/dev/chadxz/adventofcode/sonarsweep
```

### Using a REPL

```
❯ bazel build //:repl
❯ bazel-bin/repl
Welcome to Scala 2.13.6 (OpenJDK 64-Bit Server VM, Java 17.0.1).
Type in expressions for evaluation. Or try :help.

scala> 
```

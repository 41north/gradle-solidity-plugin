<h1 align="center">✨ Solidity Gradle Plugin ✨</h1>

<p align="center">
  <a href="https://github.com/41north/solidity-gradle-plugin/workflows/KtLint/badge.svg">
    <img alt="KtLint" height="20px" src="https://github.com/41north/gradle-solidity-plugin/workflows/KtLint/badge.svg" />
  </a>
  <a href="https://img.shields.io/github/license/41north/solidity-gradle-plugin?style=flat-square">
    <img alt="Gradle Solidity Plugin License" height="20px" src="https://img.shields.io/github/license/41north/solidity-gradle-plugin?style=flat-square" />
  </a>
</p>

<p align="center">
    A <b>Gradle plugin</b> that aids in compiling <a href="https://solidity.readthedocs.io/en/v0.6.6/">Solidity</a> sources with <a href="https://www.docker.com/">Docker</a>, written in <a href="https://kotlinlang.org">Kotlin</a>.
</p>

## 💡 Introduction

This plugin was developed originally for [Exflo](https://github.com/41north/exflo). As current existing solutions are either old or relies on `groovy`, we thought it might be useful as this version is written using gradle's `kotlin-dsl`. 

## 🙈 Usage

To apply the plugin, use the gradle plugin syntax:

```groovy
plugins {
    id("dev.north.fortyone.solidity") version "0.1.0"
}
```

Once the plugin is applied, you can configure it with the following options (default values are displayed below):

```groovy
solidity {
    command.set("docker run --rm")
    solidityImage.set("ethereum/solc:stable")
    evmVersion.set(EVMVersion.ISTANBUL)
    outputComponents.set(listOf(OutputComponent.BIN, OutputComponent.ABI))
    overwrite.set(true)
    optimize.set(true)
    optimize.runs(0)
    prettyJson.set(false)
    ignoreMissing.set(false)
    allowPaths.set(emptyList())
}
```

A `solidity` source set will be available like a regular `java` or `kotlin`, so you can add your source code like usual.

## 🗒️ Roadmap

* Add proper tests
* Handle properly allow paths
* Allow option to add extra arguments to solidity compiler
* ...

## 💻 Contribute

We welcome any kind of contribution or support to this project but before to do so:

* Make sure you have read the [contribution guide](/.github/CONTRIBUTING.md) for more details on how to submit a good PR (pull request).

Also, we are not only limited to technical contributions. Things that make us happy are:

* Add a [GitHub Star](https://github.com/41north/solidity-gradle-plugin/stargazers) to the project.
* Tweet about this project.
* Write a review or tutorial.

## Acknowledgements

This plugin takes inspiration from:

- [Solidity Gradle Plugin](https://github.com/web3j/solidity-gradle-plugin): Majority of source comes from here.

## 📬 Get in touch

`Gradle Solidity Plugin` has been developed initially by [°41North](https://41north.dev). 

If you think this project would be useful for your use case and want to talk more about it you can reach out to us via our contact form or by sending an email to `hello@41north.dev`. We try to respond within 48 hours and look forward to hearing from you.

## ✍️ License

`Gradle Solidity Plugin` is free and open-source software licensed under the [Apache 2.0 License](./LICENSE).

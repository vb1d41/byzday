# ByzDay

## About

ByzDay is a Java console app that shows the date in the Byzantine calendar.

## Usage

byzday \[DATE\]\
Shows the current or custom date in the Byzantine calendar.\
DATE - the Gregorian date represented as YYYY-MM-DD

## Example

```
$ java -jar byzday-1.0.3.jar

DECEMBER 4, 7534
```

```
$ java -jar byzday-1.0.3.jar 2023-04-16

APRIL 3, 7531
```

## Dependency

[ByzCal](https://github.com/vb1d41/byzcal)

## Build

On Unix/Linux:

```
./mvnw clean package
```

On Windows:

```
mvnw.cmd clean package
```

## License

This project is licensed under the terms of the [Apache License 2.0](LICENSE.txt).

# HerokuApp Test Automation (Java + Selenium)

Automated UI tests for pages of [the-internet.herokuapp.com](https://the-internet.herokuapp.com/), built to practice Selenium and test framework design.

## Tech stack

- Java 21
- Selenium 4
- TestNG
- Maven
- WebDriverManager (automatic chromedriver management)
- Docker
- GitHub Actions

## Project structure

```
src
├── main/java
│   ├── base/           # DriverManager (ThreadLocal driver), AbstractComponent (shared waits/helpers)
│   ├── pageObjects/    # One class per page, holding locators and page actions
│   └── utils/          # ConfigReader
└── test
    ├── java/testCases/ # Test classes with assertions, grouped by feature area
    │   ├── auth/
    │   ├── formsAndInputs/
    │   ├── mouseInteractions/
    │   ├── fileHandling/
    │   └── misc/
    └── resources/
        ├── config.properties
        └── testng.xml
```

Page objects follow the Page Object Model: locators and page interactions live in `pageObjects`, while assertions live only in the tests.

## Running the tests

**Prerequisites:** JDK 21, Maven, Google Chrome.

```bash
mvn test
```

Configuration is in `src/test/resources/config.properties`:

| Property     | Description                                            |
|--------------|--------------------------------------------------------|
| `baseUrl`    | Site under test                                        |
| `browser`    | Browser to use (currently `chrome`)                    |
| `implicitWait` | Implicit wait in seconds                             |
| `headless`   | `true` for headless mode (required in Docker/CI)       |

### Docker

```bash
docker build -t herokuapp-automation .
docker run --rm herokuapp-automation
```

### CI

A GitHub Actions workflow builds the Docker image and runs the suite. (Describe here whether it runs on push or manually.)

## Covered pages

- [x] A/B Testing
- [x] Add/Remove Elements
- [x] Basic Auth / Digest Auth
- [x] Broken Images
- [x] Challenging DOM
- [x] CheckBox
- [x] Context Menu
- [x] Digest Auth
- [x] Disappearing Elements
- [x] Drag and Drop
- [x] Dropdown
- [x] Dynamic Content / Controls / Loading
- [x] Entry Ad
- [x] Exit Intent
- [x] Floating Menu

## Notable techniques

- Basic/Digest auth handled with Selenium 4's `HasAuthentication`
- Image load state verified via JavaScript (`naturalWidth`)
- Canvas content verified via `toDataURL()` (changes on reload)
- Stale element handling on pages that reload
- Isolated browser session per test (`@BeforeMethod`/`@AfterMethod`)

## Known limitations

- Exit Intent: can be verified only if headless=false.
- Some pages have randomized content, so those tests assert behavior (e.g. "content changes") rather than fixed values.

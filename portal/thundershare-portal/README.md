# ThunderShare Portal

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.3.6.

## Development server

Run `yarn start`

Go to `http://localhost:4200/`

## Code scaffolding

Run `yarn ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

Or use Angular Schematics extension for VSCode.

## Build

Run `yarn build:dev` to build the project. The build artifacts will be stored in the `dist/` directory. Run `yarn build` for production build.

## Running unit tests

Run `yarn test` to execute the unit tests via [Karma](https://karma-runner.github.io).
It uses [Puppeteer](https://github.com/GoogleChrome/puppeteer) for consistent test executions.

## UI library
UI is built using Angular Components

## Docker

Run `docker compose up -d` and go to http://localhost:81

## Deployment
Production site is deployed at https://thundershare.now.sh/#/.

Staging site is deployed at https://thundershare-xxxxx.now.sh/#/ where xxxxx is a random number added by now.sh service.

Building:

  * production version:
    * builds/deploys production version to both sites
    * `ng deploy`
  
  * staging version:
    * builds staging version and deploy it to staging link
    * `ng deploy --target=staging --configuration=staging`



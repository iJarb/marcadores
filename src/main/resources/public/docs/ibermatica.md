# Ibermatica

## Links

[Documentacion incorporacion](https://drive.google.com/file/d/1feVrngSBx_9I-Z-VFgPBIljr2Brq1OwN/view?usp=sharing)

## Contactos

admpersonal@ibermatica.com  
v.lafuente@ibermatica.com   (Veronica La Fuente de Miguel)

## Ibermatica - BBVA

## Links Cells

[Cells Getting Started](https://platform.bbva.com/cells/documentation/2e422acf986848910d72b9497554b687/getting-started/what-is-cells)  
[Preparing your cells environment](https://platform.bbva.com/codelabs/#/cells/Prepare%20your%20Cells%20Environment/Overview/)  
[BBVA-Global-Web-Components](https://catalogs.platform.bbva.com/cells/BBVA-Global-Web-Components)  
[lit-element](https://lit-element.polymer-project.org/)  

NPM Configuration

```cmd
User:    juanangel.rojo.contractor
API-KEY: ************************
 npm config set registry https://globaldevtools.bbva.com/artifactory/api/npm/npm-repo
 curl -u <USER>:<API_KEY> "https://globaldevtools.bbva.com/artifactory/api/npm/auth" --insecure >> ~/.npmrc

 curl -u juanangel.rojo.contractor:aquiElToken "https://globaldevtools.bbva.com/artifactory/api/npm/auth" --insecure >> ~/.npmrc
 ```

## [Cells Pepino Testing](https://platform.bbva.com/codelabs/#/cells/Cells%20Pepino%20Testing/Overview/)  

   Node.js 8  
   cells-cli version 2.2.5 or higher installed globally (npm install -g cells-cli)  
   cells-pepino version 1.1.0 or higher dependency installed globally (npm install -g cells-pepino)  

## First App

[cells-codelab-my-goals](https://globaldevtools.bbva.com/bitbucket/projects/CELLSLABS/repos/cells-codelab-my-goals/browse)

```cmd
cells -a firstApp.json app:create
```

### firstApp.json

```json
 {
  "name": "cells -a firstApp.json app:create",
  "name": "comic-today",
  "scaffold": "helloworld",
  "e2e" : false,
  "platforms": []  
}
```

### Install the components

```cmd
npm install @bbva-web-components/bbva-list-goal@^3.0.0
npm install @bbva-web-components/bbva-button-default@^5.0.0
npm install @bbva-web-components/bbva-form-amount@^3.0.1
npm install @bbva-web-components/bbva-form-field@^4.1.0
npm install @cells-components/cells-iconset-svg@^1.2.19
npm install @cells-components/coronita-icons@^1.0.45
npm install @bbva-web-components/bbva-foundations-microillustrations@^2.0.2

```

### End2End Testing  

'created_app_name/test/e2e' folder
```
$ npm i
$ ./node_modules/.bin/cells-pepino -u <url> -c <test_config_file>

$ ./node_modules/.bin/cells-pepino -u http://localhost:8001/dist/ -c config/wdio5.local.conf.js

```


## GitHub Pages

https://ijarb.github.io/
https://ijarb.github.io/bookmarks/
https://ijarb.github.io/bookmarks/bookmarks.html
https://github.com/iJarb/bookmarks.git

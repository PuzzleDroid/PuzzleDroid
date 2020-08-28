module.exports =
/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = require('../../../ssr-module-cache.js');
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		var threw = true;
/******/ 		try {
/******/ 			modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/ 			threw = false;
/******/ 		} finally {
/******/ 			if(threw) delete installedModules[moduleId];
/******/ 		}
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 1);
/******/ })
/************************************************************************/
/******/ ({

/***/ "+diR":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Home; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return getStaticProps; });
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__("cDcd");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var next_head__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__("xnum");
/* harmony import */ var next_head__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(next_head__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _material_ui_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__("KKbo");
/* harmony import */ var _material_ui_core__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var next_translate__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__("4tRx");
/* harmony import */ var next_translate__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(next_translate__WEBPACK_IMPORTED_MODULE_3__);
/* harmony import */ var _material_ui_core_styles__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__("9Pu4");
/* harmony import */ var _material_ui_core_styles__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(_material_ui_core_styles__WEBPACK_IMPORTED_MODULE_4__);

var __jsx = react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement;





const theme = Object(_material_ui_core_styles__WEBPACK_IMPORTED_MODULE_4__["createMuiTheme"])({
  palette: {
    primary: {
      // light: will be calculated from palette.primary.main,
      main: "#ed7e00",
      dark: "#00171f"
    },
    secondary: {
      main: "#ed7e00",
      // dark: will be calculated from palette.secondary.main,
      contrastText: "#FBFBFB"
    },
    // Used by `getContrastText()` to maximize the contrast between
    // the background and the text.
    contrastThreshold: 3,
    // Used by the functions below to shift a color's luminance by approximately
    // two indexes within its tonal palette.
    // E.g., shift from Red 500 to Red 300 or Red 700.
    tonalOffset: 0.2
  }
});
function Home() {
  const {
    t
  } = Object(next_translate__WEBPACK_IMPORTED_MODULE_3__["useTranslation"])();
  const sections = ["howto", "save", "win"];

  const shwoMenuItem = key => __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], null, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Link"], {
    href: `#${key}`
  }, t(`${key}:title`)));

  const showContent = key => __jsx("div", {
    id: key
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Typography"], {
    variant: "h5",
    gutterBottom: true
  }, t(`${key}:title`)), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Typography"], {
    variant: "body1",
    gutterBottom: true,
    paragraph: true
  }, t(`${key}:content`)));

  const {
    palette
  } = theme;
  return __jsx(_material_ui_core_styles__WEBPACK_IMPORTED_MODULE_4__["ThemeProvider"], {
    theme: theme
  }, __jsx(next_head__WEBPACK_IMPORTED_MODULE_1___default.a, null, "\u2026"), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["CssBaseline"], null), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Container"], {
    maxWidth: "md",
    style: {
      marginTop: "50px",
      marginBottom: "80px"
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Box"], {
    style: {
      padding: 20
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Grid"], {
    container: true,
    spacing: 10
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Grid"], {
    item: true,
    xs: 12,
    md: 4
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["MenuList"], {
    style: {
      borderTop: `1px solid ${palette.primary.main}`,
      borderBottom: `1px solid ${palette.primary.main}`
    }
  }, sections.map(key => shwoMenuItem(key)))), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Grid"], {
    item: true,
    xs: 12,
    md: 8
  }, sections.map(key => showContent(key)))))), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["AppBar"], {
    color: "secondary",
    style: {
      top: "auto",
      bottom: 0
    },
    position: "static"
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Toolbar"], null, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Container"], {
    maxWidth: "md"
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Typography"], {
    display: "block",
    style: {
      width: "100%"
    },
    align: "right"
  }, "\xA9PuzzleDroid 2020")))));
}
const getStaticProps = async ({
  lang
}) => {
  return {
    props: {
      lang
    }
  };
};

/***/ }),

/***/ 1:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("JOY8");


/***/ }),

/***/ "11PY":
/***/ (function(module) {

module.exports = JSON.parse("{\"title\":\"Como guardar tu puntuación\",\"content\":\"A lo mejor no quieres usar ninguna cuenta y jugar como un usuario anónimo, eso está muy bien pero si quieres ser una leyenda, puedes usar tu cuenta de Google y conectarte con ella.\"}");

/***/ }),

/***/ "4tRx":
/***/ (function(module, exports) {

module.exports = require("next-translate");

/***/ }),

/***/ "9Pu4":
/***/ (function(module, exports) {

module.exports = require("@material-ui/core/styles");

/***/ }),

/***/ "AT1h":
/***/ (function(module) {

module.exports = JSON.parse("{\"title\":\"PuzzleDroid - Ayuda\"}");

/***/ }),

/***/ "JOY8":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "default", function() { return Page; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "getStaticProps", function() { return getStaticProps; });
/* harmony import */ var next_translate_I18nProvider__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__("L4qB");
/* harmony import */ var next_translate_I18nProvider__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(next_translate_I18nProvider__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__("cDcd");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _pages___WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__("+diR");
/* harmony import */ var _public_static_locales_es_common_json__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__("AT1h");
var _public_static_locales_es_common_json__WEBPACK_IMPORTED_MODULE_3___namespace = /*#__PURE__*/__webpack_require__.t("AT1h", 1);
/* harmony import */ var _public_static_locales_es_howto_json__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__("v1Jh");
var _public_static_locales_es_howto_json__WEBPACK_IMPORTED_MODULE_4___namespace = /*#__PURE__*/__webpack_require__.t("v1Jh", 1);
/* harmony import */ var _public_static_locales_es_save_json__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__("11PY");
var _public_static_locales_es_save_json__WEBPACK_IMPORTED_MODULE_5___namespace = /*#__PURE__*/__webpack_require__.t("11PY", 1);
/* harmony import */ var _public_static_locales_es_win_json__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__("hmL5");
var _public_static_locales_es_win_json__WEBPACK_IMPORTED_MODULE_6___namespace = /*#__PURE__*/__webpack_require__.t("hmL5", 1);
var __jsx = react__WEBPACK_IMPORTED_MODULE_1___default.a.createElement;

function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { _defineProperty(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

// @ts-nocheck







const namespaces = {
  'common': _public_static_locales_es_common_json__WEBPACK_IMPORTED_MODULE_3__,
  'howto': _public_static_locales_es_howto_json__WEBPACK_IMPORTED_MODULE_4__,
  'save': _public_static_locales_es_save_json__WEBPACK_IMPORTED_MODULE_5__,
  'win': _public_static_locales_es_win_json__WEBPACK_IMPORTED_MODULE_6__
};
function Page(p) {
  return __jsx(next_translate_I18nProvider__WEBPACK_IMPORTED_MODULE_0___default.a, {
    lang: "es",
    namespaces: namespaces,
    internals: {
      "defaultLanguage": "en",
      "isStaticMode": true
    }
  }, __jsx(_pages___WEBPACK_IMPORTED_MODULE_2__[/* default */ "a"], p));
}
Page = Object.assign(Page, _objectSpread({}, _pages___WEBPACK_IMPORTED_MODULE_2__[/* default */ "a"]));

if (_pages___WEBPACK_IMPORTED_MODULE_2__[/* default */ "a"] && _pages___WEBPACK_IMPORTED_MODULE_2__[/* default */ "a"].getInitialProps) {
  Page.getInitialProps = ctx => _pages___WEBPACK_IMPORTED_MODULE_2__[/* default */ "a"].getInitialProps(_objectSpread({}, ctx, {
    lang: 'es'
  }));
}

const getStaticProps = ctx => _pages___WEBPACK_IMPORTED_MODULE_2__[/* getStaticProps */ "b"](_objectSpread({}, ctx, {
  lang: 'es'
}));

/***/ }),

/***/ "KKbo":
/***/ (function(module, exports) {

module.exports = require("@material-ui/core");

/***/ }),

/***/ "L4qB":
/***/ (function(module, exports) {

module.exports = require("next-translate/I18nProvider");

/***/ }),

/***/ "cDcd":
/***/ (function(module, exports) {

module.exports = require("react");

/***/ }),

/***/ "hmL5":
/***/ (function(module) {

module.exports = JSON.parse("{\"title\":\"Como se gana\",\"content\":\"El juego tiene 10 niveles, en cada nivel vas a conseguir muchas más piezas para mover, sabemos que te encantan los retos ;)\"}");

/***/ }),

/***/ "v1Jh":
/***/ (function(module) {

module.exports = JSON.parse("{\"title\":\"Como se resuelve\",\"content\":\"Para resolver el puzzle debes de ir moviendo las piezas en puzzle, deslizandolas hasta que todas tengan el orden correcto. Una vez que cada una este colocada en la posición correcta, el puzzle estará completado y pasarás al siguiente nivel.\\nCuando el puzzle esté resuelto tu puntuación se guardará con la de otros usuarios en un ranking.\"}");

/***/ }),

/***/ "xnum":
/***/ (function(module, exports) {

module.exports = require("next/head");

/***/ })

/******/ });
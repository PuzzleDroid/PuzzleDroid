webpackHotUpdate("static/development/pages/index.js",{

/***/ "./node_modules/@babel/runtime/helpers/asyncToGenerator.js":
/*!*****************************************************************!*\
  !*** ./node_modules/@babel/runtime/helpers/asyncToGenerator.js ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function asyncGeneratorStep(gen, resolve, reject, _next, _throw, key, arg) {
  try {
    var info = gen[key](arg);
    var value = info.value;
  } catch (error) {
    reject(error);
    return;
  }

  if (info.done) {
    resolve(value);
  } else {
    Promise.resolve(value).then(_next, _throw);
  }
}

function _asyncToGenerator(fn) {
  return function () {
    var self = this,
        args = arguments;
    return new Promise(function (resolve, reject) {
      var gen = fn.apply(self, args);

      function _next(value) {
        asyncGeneratorStep(gen, resolve, reject, _next, _throw, "next", value);
      }

      function _throw(err) {
        asyncGeneratorStep(gen, resolve, reject, _next, _throw, "throw", err);
      }

      _next(undefined);
    });
  };
}

module.exports = _asyncToGenerator;

/***/ }),

/***/ "./node_modules/next-translate/DynamicNamespaces.js":
/*!**********************************************************!*\
  !*** ./node_modules/next-translate/DynamicNamespaces.js ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
var _interopRequireWildcard=__webpack_require__(/*! @babel/runtime/helpers/interopRequireWildcard */ "./node_modules/@babel/runtime/helpers/interopRequireWildcard.js"),_interopRequireDefault=__webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/@babel/runtime/helpers/interopRequireDefault.js");Object.defineProperty(exports,"__esModule",{value:!0}),exports["default"]=DynamicNamespaces;var _regenerator=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js")),_asyncToGenerator2=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/asyncToGenerator.js")),_react=_interopRequireWildcard(__webpack_require__(/*! react */ "./node_modules/react/index.js")),_I18nProvider=_interopRequireDefault(__webpack_require__(/*! ./I18nProvider */ "./node_modules/next-translate/I18nProvider.js")),_useTranslation2=_interopRequireDefault(__webpack_require__(/*! ./useTranslation */ "./node_modules/next-translate/useTranslation.js")),__jsx=_react["default"].createElement;function DynamicNamespaces(a){function b(){return c.apply(this,arguments)}function c(){return c=(0,_asyncToGenerator2["default"])(_regenerator["default"].mark(function a(){var b;return _regenerator["default"].wrap(function(a){for(;;)switch(a.prev=a.next){case 0:if("function"==typeof d){a.next=2;break}return a.abrupt("return");case 2:return a.next=4,Promise.all(f.map(function(a){return d(j,a)}));case 4:b=a.sent,p(b),m(!0);case 7:case"end":return a.stop();}},a)})),c.apply(this,arguments)}var d=a.dynamic,e=a.namespaces,f=void 0===e?[]:e,g=a.fallback,h=a.children,i=(0,_useTranslation2["default"])(),j=i.lang,k=(0,_react.useState)(!1),l=k[0],m=k[1],n=(0,_react.useState)({}),o=n[0],p=n[1];return(0,_react.useEffect)(function(){b()},[]),l?__jsx(_I18nProvider["default"],{lang:j,namespaces:f.reduce(function(a,b,c){return a[b]=o[c],a},{})},h):g||null}

/***/ }),

/***/ "./node_modules/next-translate/Trans.js":
/*!**********************************************!*\
  !*** ./node_modules/next-translate/Trans.js ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
var _interopRequireDefault=__webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/@babel/runtime/helpers/interopRequireDefault.js"),_interopRequireWildcard=__webpack_require__(/*! @babel/runtime/helpers/interopRequireWildcard */ "./node_modules/@babel/runtime/helpers/interopRequireWildcard.js");Object.defineProperty(exports,"__esModule",{value:!0}),exports["default"]=Trans;var _react=_interopRequireWildcard(__webpack_require__(/*! react */ "./node_modules/react/index.js")),_slicedToArray2=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/slicedToArray */ "./node_modules/@babel/runtime/helpers/slicedToArray.js")),_useTranslation2=_interopRequireDefault(__webpack_require__(/*! ./useTranslation */ "./node_modules/next-translate/useTranslation.js")),__jsx=_react["default"].createElement;function _createForOfIteratorHelper(a,b){var c;if("undefined"==typeof Symbol||null==a[Symbol.iterator]){if(Array.isArray(a)||(c=_unsupportedIterableToArray(a))||b&&a&&"number"==typeof a.length){c&&(a=c);var d=0,e=function(){};return{s:e,n:function n(){return d>=a.length?{done:!0}:{done:!1,value:a[d++]}},e:function e(a){throw a},f:e}}throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}var f,g=!0,h=!1;return{s:function s(){c=a[Symbol.iterator]()},n:function n(){var a=c.next();return g=a.done,a},e:function e(a){h=!0,f=a},f:function f(){try{g||null==c["return"]||c["return"]()}finally{if(h)throw f}}}}function _unsupportedIterableToArray(a,b){if(a){if("string"==typeof a)return _arrayLikeToArray(a,b);var c=Object.prototype.toString.call(a).slice(8,-1);return"Object"===c&&a.constructor&&(c=a.constructor.name),"Map"===c||"Set"===c?Array.from(a):"Arguments"===c||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(c)?_arrayLikeToArray(a,b):void 0}}function _arrayLikeToArray(a,b){(null==b||b>a.length)&&(b=a.length);for(var c=0,d=Array(b);c<b;c++)d[c]=a[c];return d}var tagRe=/<(\d+)>(.*?)<\/\1>|<(\d+)\/>/,nlRe=/(?:\r\n|\r|\n)/g;function getElements(a){if(!a.length)return[];var b=a.slice(0,4),c=(0,_slicedToArray2["default"])(b,4),d=c[0],e=c[1],f=c[2],g=c[3];return[[parseInt(d||f),e||"",g]].concat(getElements(a.slice(4,a.length)))}function formatElements(a){var b=1<arguments.length&&arguments[1]!==void 0?arguments[1]:[],c=a.replace(nlRe,"").split(tagRe);if(1===c.length)return a;var d=[],e=c.shift();e&&d.push(e);var f,g=_createForOfIteratorHelper(getElements(c));try{for(g.s();!(f=g.n()).done;){var h=(0,_slicedToArray2["default"])(f.value,3),i=h[0],j=h[1],k=h[2],l=b[i]||__jsx(_react.Fragment,null);d.push((0,_react.cloneElement)(l,{key:i},j?formatElements(j,b):l.props.children)),k&&d.push(k)}}catch(a){g.e(a)}finally{g.f()}return d}function Trans(a){var b=a.i18nKey,c=a.values,d=a.components,e=(0,_useTranslation2["default"])(),f=e.t,g=(0,_react.useMemo)(function(){var a=f(b,c);return d&&0!==d.length?formatElements(a,d):a},[b,c,d]);return g}

/***/ }),

/***/ "./node_modules/next-translate/_helpers/getDefaultLang.js":
/*!****************************************************************!*\
  !*** ./node_modules/next-translate/_helpers/getDefaultLang.js ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
Object.defineProperty(exports,"__esModule",{value:!0}),exports["default"]=getDefaultLang;function getDefaultLang(a,b){return"function"==typeof b.defaultLanguage?b.defaultLanguage(a):b.defaultLanguage}

/***/ }),

/***/ "./node_modules/next-translate/_helpers/getPageNamespaces.js":
/*!*******************************************************************!*\
  !*** ./node_modules/next-translate/_helpers/getPageNamespaces.js ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
var _interopRequireDefault=__webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/@babel/runtime/helpers/interopRequireDefault.js");Object.defineProperty(exports,"__esModule",{value:!0}),exports["default"]=getPageNamespaces;var _toConsumableArray2=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/toConsumableArray */ "./node_modules/@babel/runtime/helpers/toConsumableArray.js")),_regenerator=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js")),_asyncToGenerator2=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/asyncToGenerator.js"));function flat(b){return b.reduce(function(a,b){return a.concat(b)},[])}function getPageNamespaces(){return _getPageNamespaces.apply(this,arguments)}function _getPageNamespaces(){return _getPageNamespaces=(0,_asyncToGenerator2["default"])(_regenerator["default"].mark(function a(b,c,d){var e,f,g,h,i;return _regenerator["default"].wrap(function(a){for(;;)switch(a.prev=a.next){case 0:return e=b.pages,f=void 0===e?{}:e,g="rgx:",h=function(){var a=(0,_asyncToGenerator2["default"])(_regenerator["default"].mark(function a(b){return _regenerator["default"].wrap(function(a){for(;;)switch(a.prev=a.next){case 0:return a.abrupt("return","function"==typeof b?b(d):b||[]);case 1:case"end":return a.stop();}},a)}));return function(){return a.apply(this,arguments)}}(),i=Object.keys(f).reduce(function(a,b){return b.substring(0,g.length)===g&&new RegExp(b.replace(g,"")).test(c)&&a.push(h(f[b])),a},[]),a.t0=[],a.t1=_toConsumableArray2["default"],a.next=8,h(f["*"]);case 8:return a.t2=a.sent,a.t3=(0,a.t1)(a.t2),a.t4=_toConsumableArray2["default"],a.next=13,h(f[c]);case 13:return a.t5=a.sent,a.t6=(0,a.t4)(a.t5),a.t7=_toConsumableArray2["default"],a.t8=flat,a.next=19,Promise.all(i);case 19:return a.t9=a.sent,a.t10=(0,a.t8)(a.t9),a.t11=(0,a.t7)(a.t10),a.abrupt("return",a.t0.concat.call(a.t0,a.t3,a.t6,a.t11));case 23:case"end":return a.stop();}},a)})),_getPageNamespaces.apply(this,arguments)}

/***/ }),

/***/ "./node_modules/next-translate/_helpers/startsWithLang.js":
/*!****************************************************************!*\
  !*** ./node_modules/next-translate/_helpers/startsWithLang.js ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
Object.defineProperty(exports,"__esModule",{value:!0}),exports["default"]=startsWithLang;function startsWithLang(a,b){return b.some(function(b){return new RegExp("(^/".concat(b,"/)|(^/").concat(b,"$)")).test(a)})}

/***/ }),

/***/ "./node_modules/next-translate/appWithI18n.js":
/*!****************************************************!*\
  !*** ./node_modules/next-translate/appWithI18n.js ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
var _interopRequireDefault=__webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/@babel/runtime/helpers/interopRequireDefault.js");Object.defineProperty(exports,"__esModule",{value:!0}),exports["default"]=appWithI18n;var _regenerator=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js")),_defineProperty2=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/defineProperty */ "./node_modules/@babel/runtime/helpers/defineProperty.js")),_asyncToGenerator2=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/asyncToGenerator.js")),_react=_interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/react/index.js")),_app=_interopRequireDefault(__webpack_require__(/*! next/app */ "./node_modules/next/app.js")),_I18nProvider=_interopRequireDefault(__webpack_require__(/*! ./I18nProvider */ "./node_modules/next-translate/I18nProvider.js")),_getDefaultLang=_interopRequireDefault(__webpack_require__(/*! ./_helpers/getDefaultLang */ "./node_modules/next-translate/_helpers/getDefaultLang.js")),_getPageNamespaces=_interopRequireDefault(__webpack_require__(/*! ./_helpers/getPageNamespaces */ "./node_modules/next-translate/_helpers/getPageNamespaces.js")),_startsWithLang=_interopRequireDefault(__webpack_require__(/*! ./_helpers/startsWithLang */ "./node_modules/next-translate/_helpers/startsWithLang.js")),__jsx=_react["default"].createElement;function ownKeys(a,b){var c=Object.keys(a);if(Object.getOwnPropertySymbols){var d=Object.getOwnPropertySymbols(a);b&&(d=d.filter(function(b){return Object.getOwnPropertyDescriptor(a,b).enumerable})),c.push.apply(c,d)}return c}function _objectSpread(a){for(var b,c=1;c<arguments.length;c++)b=null==arguments[c]?{}:arguments[c],c%2?ownKeys(Object(b),!0).forEach(function(c){(0,_defineProperty2["default"])(a,c,b[c])}):Object.getOwnPropertyDescriptors?Object.defineProperties(a,Object.getOwnPropertyDescriptors(b)):ownKeys(Object(b)).forEach(function(c){Object.defineProperty(a,c,Object.getOwnPropertyDescriptor(b,c))});return a}function getLang(a,b){var c=a.req,d=a.asPath,e=void 0===d?"":d;return c?c.query.lang||b.defaultLanguage:(0,_startsWithLang["default"])(e,b.allLanguages)?e.split("/")[1]:b.defaultLanguage}function removeTrailingSlash(){var a=0<arguments.length&&arguments[0]!==void 0?arguments[0]:"";return 1<a.length&&a.endsWith("/")?a.slice(0,-1):a}function appWithI18n(a){function b(b){var d=b.lang,e=b.namespaces,f=b.defaultLanguage,g=c.defaultLangRedirect;return __jsx(_I18nProvider["default"],{lang:d,namespaces:e,internals:{defaultLangRedirect:g,defaultLanguage:f}},__jsx(a,b))}var c=1<arguments.length&&void 0!==arguments[1]?arguments[1]:{};return b.getInitialProps=function(){var b=(0,_asyncToGenerator2["default"])(_regenerator["default"].mark(function b(d){var e,f,g,h,i,j,k,l,m;return _regenerator["default"].wrap(function(b){for(;;)switch(b.prev=b.next){case 0:if(e=d.Component,f=d.ctx,g=f.req?(0,_getDefaultLang["default"])(f.req,c):__NEXT_DATA__.props.defaultLanguage,h=getLang(f,_objectSpread(_objectSpread({},c),{},{defaultLanguage:g})),i=a.getInitialProps||_app["default"].getInitialProps,j={pageProps:{}},!i){b.next=12;break}return b.next=8,i(_objectSpread(_objectSpread({},d),{},{lang:h}));case 8:if(b.t0=b.sent,b.t0){b.next=11;break}b.t0={};case 11:j=b.t0;case 12:return k=removeTrailingSlash(f.pathname),b.next=15,(0,_getPageNamespaces["default"])(c,k,f);case 15:return l=b.sent,b.next=18,Promise.all(l.map(function(a){return"function"==typeof c.loadLocaleFrom?c.loadLocaleFrom(h,a):Promise.resolve([])}))["catch"](function(){});case 18:if(b.t1=b.sent,b.t1){b.next=21;break}b.t1=[];case 21:return m=b.t1,b.abrupt("return",_objectSpread(_objectSpread({},j),{},{lang:h,defaultLanguage:g,namespaces:l.reduce(function(a,b,c){return a[b]=m[c],a},{})}));case 23:case"end":return b.stop();}},b)}));return function(){return b.apply(this,arguments)}}(),b}

/***/ }),

/***/ "./node_modules/next-translate/i18nMiddleware.js":
/*!*******************************************************!*\
  !*** ./node_modules/next-translate/i18nMiddleware.js ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
var _interopRequireDefault=__webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/@babel/runtime/helpers/interopRequireDefault.js");Object.defineProperty(exports,"__esModule",{value:!0}),exports["default"]=i18nMiddleware;var _slicedToArray2=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/slicedToArray */ "./node_modules/@babel/runtime/helpers/slicedToArray.js")),_defineProperty2=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/defineProperty */ "./node_modules/@babel/runtime/helpers/defineProperty.js")),_getDefaultLang=_interopRequireDefault(__webpack_require__(/*! ./_helpers/getDefaultLang */ "./node_modules/next-translate/_helpers/getDefaultLang.js")),_startsWithLang=_interopRequireDefault(__webpack_require__(/*! ./_helpers/startsWithLang */ "./node_modules/next-translate/_helpers/startsWithLang.js"));function ownKeys(a,b){var c=Object.keys(a);if(Object.getOwnPropertySymbols){var d=Object.getOwnPropertySymbols(a);b&&(d=d.filter(function(b){return Object.getOwnPropertyDescriptor(a,b).enumerable})),c.push.apply(c,d)}return c}function _objectSpread(a){for(var b,c=1;c<arguments.length;c++)b=null==arguments[c]?{}:arguments[c],c%2?ownKeys(Object(b),!0).forEach(function(c){(0,_defineProperty2["default"])(a,c,b[c])}):Object.getOwnPropertyDescriptors?Object.defineProperties(a,Object.getOwnPropertyDescriptors(b)):ownKeys(Object(b)).forEach(function(c){Object.defineProperty(a,c,Object.getOwnPropertyDescriptor(b,c))});return a}function i18nMiddleware(){var a=0<arguments.length&&void 0!==arguments[0]?arguments[0]:{},b=a.ignoreRoutes,c=void 0===b?["/_next/","/static/","/favicon.ico","/manifest.json","/robots.txt"]:b,d=a.allLanguages,e=void 0===d?[]:d,f=a.defaultLangRedirect,g=a.redirectToDefaultLang;return void 0!==g&&(f=g?"lang-path":void 0,console.log("\x1B[33m%s\x1B[0m","\uD83D\uDEA8 redirectToDefaultLang is deprecated and will be removed in future major versions. Use defaultLangRedirect instead. Docs: https://github.com/vinissimus/next-translate/blob/master/README.md#4-configuration")),function(b,d,e){var g=c.some(function(a){return b.url.startsWith(a)}),h=(0,_getDefaultLang["default"])(b,a)||"en";if(g)return e();if(!(0,_startsWithLang["default"])(b.url,a.allLanguages))return"lang-path"===f?void d.redirect(301,"/".concat(h).concat(b.url)):(b.lang=h,b.query=_objectSpread(_objectSpread({},b.query),{},{lang:h}),e());var i=b.url.split("/")[1];if(b.url=b.url.replace("/".concat(i),"")||"/","root"===f&&i===h)return void d.redirect(301,b.url);var j=c.filter(function(a){return b.url.startsWith(a)}),k=(0,_slicedToArray2["default"])(j,1),l=k[0];return l?void d.redirect(301,l):(b.lang=i,b.query=_objectSpread(_objectSpread({},b.query),{},{lang:i}),e())}}

/***/ }),

/***/ "./node_modules/next-translate/index.js":
/*!**********************************************!*\
  !*** ./node_modules/next-translate/index.js ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
var _interopRequireDefault=__webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/@babel/runtime/helpers/interopRequireDefault.js");Object.defineProperty(exports,"__esModule",{value:!0}),Object.defineProperty(exports,"DynamicNamespaces",{enumerable:!0,get:function get(){return _DynamicNamespaces["default"]}}),Object.defineProperty(exports,"I18nProvider",{enumerable:!0,get:function get(){return _I18nProvider["default"]}}),Object.defineProperty(exports,"Trans",{enumerable:!0,get:function get(){return _Trans["default"]}}),Object.defineProperty(exports,"appWithI18n",{enumerable:!0,get:function get(){return _appWithI18n["default"]}}),Object.defineProperty(exports,"i18nMiddleware",{enumerable:!0,get:function get(){return _i18nMiddleware["default"]}}),Object.defineProperty(exports,"useTranslation",{enumerable:!0,get:function get(){return _useTranslation["default"]}}),Object.defineProperty(exports,"withTranslation",{enumerable:!0,get:function get(){return _withTranslation["default"]}});var _DynamicNamespaces=_interopRequireDefault(__webpack_require__(/*! ./DynamicNamespaces */ "./node_modules/next-translate/DynamicNamespaces.js")),_I18nProvider=_interopRequireDefault(__webpack_require__(/*! ./I18nProvider */ "./node_modules/next-translate/I18nProvider.js")),_Trans=_interopRequireDefault(__webpack_require__(/*! ./Trans */ "./node_modules/next-translate/Trans.js")),_appWithI18n=_interopRequireDefault(__webpack_require__(/*! ./appWithI18n */ "./node_modules/next-translate/appWithI18n.js")),_i18nMiddleware=_interopRequireDefault(__webpack_require__(/*! ./i18nMiddleware */ "./node_modules/next-translate/i18nMiddleware.js")),_useTranslation=_interopRequireDefault(__webpack_require__(/*! ./useTranslation */ "./node_modules/next-translate/useTranslation.js")),_withTranslation=_interopRequireDefault(__webpack_require__(/*! ./withTranslation */ "./node_modules/next-translate/withTranslation.js"));

/***/ }),

/***/ "./node_modules/next-translate/useTranslation.js":
/*!*******************************************************!*\
  !*** ./node_modules/next-translate/useTranslation.js ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
var _interopRequireDefault=__webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/@babel/runtime/helpers/interopRequireDefault.js");Object.defineProperty(exports,"__esModule",{value:!0}),exports["default"]=useTranslation;var _react=__webpack_require__(/*! react */ "./node_modules/react/index.js"),_context=_interopRequireDefault(__webpack_require__(/*! ./_context */ "./node_modules/next-translate/_context.js"));function useTranslation(){return(0,_react.useContext)(_context["default"])}

/***/ }),

/***/ "./node_modules/next-translate/withTranslation.js":
/*!********************************************************!*\
  !*** ./node_modules/next-translate/withTranslation.js ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
var _interopRequireDefault=__webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/@babel/runtime/helpers/interopRequireDefault.js");Object.defineProperty(exports,"__esModule",{value:!0}),exports["default"]=withTranslation;var _react=_interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/react/index.js")),_extends2=_interopRequireDefault(__webpack_require__(/*! @babel/runtime/helpers/extends */ "./node_modules/@babel/runtime/helpers/extends.js")),_useTranslation=_interopRequireDefault(__webpack_require__(/*! ./useTranslation */ "./node_modules/next-translate/useTranslation.js")),__jsx=_react["default"].createElement;function withTranslation(a){return function(b){var c=(0,_useTranslation["default"])();return __jsx(a,(0,_extends2["default"])({i18n:c},b))}}

/***/ }),

/***/ "./node_modules/next/app.js":
/*!**********************************!*\
  !*** ./node_modules/next/app.js ***!
  \**********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! ./dist/pages/_app */ "./node_modules/next/dist/pages/_app.js")


/***/ }),

/***/ "./node_modules/next/dist/pages/_app.js":
/*!**********************************************!*\
  !*** ./node_modules/next/dist/pages/_app.js ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _classCallCheck = __webpack_require__(/*! @babel/runtime/helpers/classCallCheck */ "./node_modules/@babel/runtime/helpers/classCallCheck.js");

var _createClass = __webpack_require__(/*! @babel/runtime/helpers/createClass */ "./node_modules/@babel/runtime/helpers/createClass.js");

var _inherits = __webpack_require__(/*! @babel/runtime/helpers/inherits */ "./node_modules/@babel/runtime/helpers/inherits.js");

var _possibleConstructorReturn = __webpack_require__(/*! @babel/runtime/helpers/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/possibleConstructorReturn.js");

var _getPrototypeOf = __webpack_require__(/*! @babel/runtime/helpers/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/getPrototypeOf.js");

var _regeneratorRuntime = __webpack_require__(/*! @babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");

function _createSuper(Derived) { var hasNativeReflectConstruct = _isNativeReflectConstruct(); return function _createSuperInternal() { var Super = _getPrototypeOf(Derived), result; if (hasNativeReflectConstruct) { var NewTarget = _getPrototypeOf(this).constructor; result = Reflect.construct(Super, arguments, NewTarget); } else { result = Super.apply(this, arguments); } return _possibleConstructorReturn(this, result); }; }

function _isNativeReflectConstruct() { if (typeof Reflect === "undefined" || !Reflect.construct) return false; if (Reflect.construct.sham) return false; if (typeof Proxy === "function") return true; try { Date.prototype.toString.call(Reflect.construct(Date, [], function () {})); return true; } catch (e) { return false; } }

var _interopRequireDefault = __webpack_require__(/*! @babel/runtime/helpers/interopRequireDefault */ "./node_modules/@babel/runtime/helpers/interopRequireDefault.js");

exports.__esModule = true;
exports.Container = Container;
exports.createUrl = createUrl;
exports["default"] = void 0;

var _react = _interopRequireDefault(__webpack_require__(/*! react */ "./node_modules/react/index.js"));

var _utils = __webpack_require__(/*! ../next-server/lib/utils */ "./node_modules/next/dist/next-server/lib/utils.js");

exports.AppInitialProps = _utils.AppInitialProps;
/**
* `App` component is used for initialize of pages. It allows for overwriting and full control of the `page` initialization.
* This allows for keeping state between navigation, custom error handling, injecting additional data.
*/

function appGetInitialProps(_ref) {
  var Component, ctx, pageProps;
  return _regeneratorRuntime.async(function appGetInitialProps$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          Component = _ref.Component, ctx = _ref.ctx;
          _context.next = 3;
          return _regeneratorRuntime.awrap((0, _utils.loadGetInitialProps)(Component, ctx));

        case 3:
          pageProps = _context.sent;
          return _context.abrupt("return", {
            pageProps: pageProps
          });

        case 5:
        case "end":
          return _context.stop();
      }
    }
  }, null, null, null, Promise);
}

var App = /*#__PURE__*/function (_react$default$Compon) {
  _inherits(App, _react$default$Compon);

  var _super = _createSuper(App);

  function App() {
    _classCallCheck(this, App);

    return _super.apply(this, arguments);
  }

  _createClass(App, [{
    key: "componentDidCatch",
    // Kept here for backwards compatibility.
    // When someone ended App they could call `super.componentDidCatch`.
    // @deprecated This method is no longer needed. Errors are caught at the top level
    value: function componentDidCatch(error, _errorInfo) {
      throw error;
    }
  }, {
    key: "render",
    value: function render() {
      var _this$props = this.props,
          router = _this$props.router,
          Component = _this$props.Component,
          pageProps = _this$props.pageProps,
          __N_SSG = _this$props.__N_SSG,
          __N_SSP = _this$props.__N_SSP;
      return _react["default"].createElement(Component, Object.assign({}, pageProps, // we don't add the legacy URL prop if it's using non-legacy
      // methods like getStaticProps and getServerSideProps
      !(__N_SSG || __N_SSP) ? {
        url: createUrl(router)
      } : {}));
    }
  }]);

  return App;
}(_react["default"].Component);

exports["default"] = App;
App.origGetInitialProps = appGetInitialProps;
App.getInitialProps = appGetInitialProps;
var warnContainer;
var warnUrl;

if (true) {
  warnContainer = (0, _utils.execOnce)(function () {
    console.warn("Warning: the `Container` in `_app` has been deprecated and should be removed. https://err.sh/zeit/next.js/app-container-deprecated");
  });
  warnUrl = (0, _utils.execOnce)(function () {
    console.error("Warning: the 'url' property is deprecated. https://err.sh/zeit/next.js/url-deprecated");
  });
} // @deprecated noop for now until removal


function Container(p) {
  if (true) warnContainer();
  return p.children;
}

function createUrl(router) {
  // This is to make sure we don't references the router object at call time
  var pathname = router.pathname,
      asPath = router.asPath,
      query = router.query;
  return {
    get query() {
      if (true) warnUrl();
      return query;
    },

    get pathname() {
      if (true) warnUrl();
      return pathname;
    },

    get asPath() {
      if (true) warnUrl();
      return asPath;
    },

    back: function back() {
      if (true) warnUrl();
      router.back();
    },
    push: function push(url, as) {
      if (true) warnUrl();
      return router.push(url, as);
    },
    pushTo: function pushTo(href, as) {
      if (true) warnUrl();
      var pushRoute = as ? href : '';
      var pushUrl = as || href;
      return router.push(pushRoute, pushUrl);
    },
    replace: function replace(url, as) {
      if (true) warnUrl();
      return router.replace(url, as);
    },
    replaceTo: function replaceTo(href, as) {
      if (true) warnUrl();
      var replaceRoute = as ? href : '';
      var replaceUrl = as || href;
      return router.replace(replaceRoute, replaceUrl);
    }
  };
}

/***/ }),

/***/ "./pages_/index.js":
/*!*************************!*\
  !*** ./pages_/index.js ***!
  \*************************/
/*! exports provided: __N_SSG, default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__N_SSG", function() { return __N_SSG; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "default", function() { return Home; });
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var next_head__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! next/head */ "./node_modules/next/dist/next-server/lib/head.js");
/* harmony import */ var next_head__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(next_head__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _material_ui_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @material-ui/core */ "./node_modules/@material-ui/core/esm/index.js");
/* harmony import */ var next_translate__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! next-translate */ "./node_modules/next-translate/index.js");
/* harmony import */ var next_translate__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(next_translate__WEBPACK_IMPORTED_MODULE_3__);
/* harmony import */ var _material_ui_core_styles__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @material-ui/core/styles */ "./node_modules/@material-ui/core/esm/styles/index.js");
var _jsxFileName = "/Users/JAVI/StudioProjects/PuzzleDroid/help/pages_/index.js";

var __jsx = react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement;





var theme = Object(_material_ui_core_styles__WEBPACK_IMPORTED_MODULE_4__["createMuiTheme"])({
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
var __N_SSG = true;
function Home() {
  var _this = this;

  var _useTranslation = Object(next_translate__WEBPACK_IMPORTED_MODULE_3__["useTranslation"])(),
      t = _useTranslation.t;

  var sections = ["howto", "save", "win"];

  var shwoMenuItem = function shwoMenuItem(key) {
    return __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 45,
        columnNumber: 5
      }
    }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Link"], {
      href: "#".concat(key),
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 46,
        columnNumber: 7
      }
    }, t("".concat(key, ":title"))));
  };

  var showContent = function showContent(key) {
    return __jsx("div", {
      id: key,
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 51,
        columnNumber: 5
      }
    }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Typography"], {
      variant: "h5",
      gutterBottom: true,
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 52,
        columnNumber: 7
      }
    }, t("".concat(key, ":title"))), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Typography"], {
      variant: "body1",
      gutterBottom: true,
      paragraph: true,
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 55,
        columnNumber: 7
      }
    }, t("".concat(key, ":content"))));
  };

  var palette = theme.palette;
  return __jsx(_material_ui_core_styles__WEBPACK_IMPORTED_MODULE_4__["ThemeProvider"], {
    theme: theme,
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 64,
      columnNumber: 5
    }
  }, __jsx(next_head__WEBPACK_IMPORTED_MODULE_1___default.a, {
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 65,
      columnNumber: 7
    }
  }, "\u2026"), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["CssBaseline"], {
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 66,
      columnNumber: 7
    }
  }), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["AppBar"], {
    component: "span",
    position: "static",
    style: {
      padding: "10px"
    },
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 67,
      columnNumber: 7
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Toolbar"], {
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 68,
      columnNumber: 9
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Container"], {
    maxWidth: "md",
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 69,
      columnNumber: 11
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Typography"], {
    color: "textSecondary",
    variant: "h4",
    style: {
      fontWeight: "bold"
    },
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 70,
      columnNumber: 13
    }
  }, t("title"))))), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Container"], {
    maxWidth: "md",
    style: {
      marginTop: "50px",
      marginBottom: "80px"
    },
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 80,
      columnNumber: 7
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Box"], {
    style: {
      padding: 20
    },
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 84,
      columnNumber: 9
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Grid"], {
    container: true,
    spacing: 10,
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 85,
      columnNumber: 11
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Grid"], {
    item: true,
    xs: 12,
    md: 4,
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 86,
      columnNumber: 13
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["MenuList"], {
    style: {
      borderTop: "1px solid ".concat(palette.primary.main),
      borderBottom: "1px solid ".concat(palette.primary.main)
    },
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 87,
      columnNumber: 15
    }
  }, sections.map(function (key) {
    return shwoMenuItem(key);
  }))), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Grid"], {
    item: true,
    xs: 12,
    md: 8,
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 96,
      columnNumber: 13
    }
  }, sections.map(function (key) {
    return showContent(key);
  }))))), __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["AppBar"], {
    color: "secondary",
    style: {
      top: "auto",
      bottom: 0
    },
    position: "static",
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 102,
      columnNumber: 7
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Toolbar"], {
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 110,
      columnNumber: 9
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Container"], {
    maxWidth: "md",
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 111,
      columnNumber: 11
    }
  }, __jsx(_material_ui_core__WEBPACK_IMPORTED_MODULE_2__["Typography"], {
    display: "block",
    style: {
      width: "100%"
    },
    align: "right",
    __self: this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 112,
      columnNumber: 13
    }
  }, "\xA9PuzzleDroid 2020")))));
}

/***/ })

})
//# sourceMappingURL=index.js.030ef9c3a20c22bb791a.hot-update.js.map
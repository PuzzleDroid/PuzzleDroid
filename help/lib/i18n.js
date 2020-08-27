const NextI18Next = require("next-i18next").default;
const path = require("path");

module.exports = new NextI18Next({
  otherLanguages: ["es"],
  supportedLngs: ["es"],
  lowerCaseLng: true,
  nonExplicitSupportedLngs: true,
  nonExplicitWhitelist: true,
  debug: true,
  load: "all",
  order: ["navigator"],
  localePath: path.resolve("./public/static/locales"),
});

const isProd = process.env.NODE_ENV === "production";

module.exports = {
  basePath: "/PuzzleDroid",
  assetPrefix: isProd ? "/PuzzleDroid" : "",
};

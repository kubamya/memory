const server = require("./src/api/server.js");
module.exports = {
  publicPath: "./",
  devServer: {
    port: 7000,
    proxy: {
      "/settings": {
        target: server.server_url,
        changeOrigin: true,
        pathRewrite: {
          "^/": "/",
        },
      },
      "/passages": {
        target: server.server_url,
        changeOrigin: true,
        pathRewrite: {
          "^/": "/",
        },
      },
      "/user": {
        target: server.server_url,
        changeOrigin: true,
        pathRewrite: {
          "^/": "/",
        },
      },
    },
  },
};

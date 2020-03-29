const path = require('path');

module.exports = {
  outputDir: path.join(path.dirname(__dirname), '/tasks-back/src/main/resources/static'),
  devServer: {
    port: 8888,
    proxy: {
      '/': {
        target: 'http://localhost:8080',
      },
    },
  },
};

var FEATURE_NAME = 'ACRA_reporter'
var taker = function(some) {
    console.log('Result: ' + some);
}
var error = function(err) {
    console.log('Error: ' + err);
}

module.exports = {
    handleSilentException : function(msg) {
        console.log(FEATURE_NAME + '#handleSilentException: ' + msg);
        cordova.exec(taker, error, FEATURE_NAME, 'handleSilentException', [ msg ]);
    },
    handleException : function(msg) {
        console.log(FEATURE_NAME + '#handleException: ' + msg);
        cordova.exec(taker, error, FEATURE_NAME, 'handleException', [ msg ]);
    }
};

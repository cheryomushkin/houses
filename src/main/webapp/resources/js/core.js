"use strict";

require.config({
    paths: {
        jQuery: '../js/libs/jquery/jquery',
        Bootstrap: '../js/libs/bootstrap/bootstrap',
        Angular: '../js/libs/angular/angular',
        AngularUiRouter: '../js/libs/angular/angular-ui-router',
        AngularResource: '../js/libs/angular/angular-resource',
        Lodash: '../js/libs/lodash/lodash',
        App: '../js/app/module'
    },
    priority: [
        'jQuery',
        'Angular',
        'AngularUiRouter',
        'AngularResource',
        'Lodash',
        'Bootstrap',
        'App'
    ],
    shim: {
        Angular: ['jQuery'],
        Bootstrap: ['jQuery'],
        AngularUiRouter: ['Angular'],
        AngularResource: ['Angular']
    }
});

require([
    'jQuery',
    'Bootstrap',
    'Angular',
    'AngularUiRouter',
    'AngularResource',
    'Lodash',
    'App'
], function () {

});
"use strict";

require.config({
    paths: {
        jQuery: '../js/libs/jquery/jquery',
        Bootstrap: '../js/libs/bootstrap/bootstrap',
        Bootbox: '../js/libs/bootstrap/bootbox',
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
        'Bootbox',
        'App'
    ],
    shim: {
        Angular: ['jQuery'],
        Bootstrap: ['jQuery'],
        Bootbox: ['Bootstrap'],
        AngularUiRouter: ['Angular'],
        AngularResource: ['Angular']
    }
});

require([
    'jQuery',
    'Bootstrap',
    'Bootbox',
    'Angular',
    'AngularUiRouter',
    'AngularResource',
    'Lodash',
    'App'
], function () {

});
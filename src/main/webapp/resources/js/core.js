"use strict";

require.config({
    paths: {
        jQuery: '../js/libs/jquery/jquery',
        Bootstrap: '../js/libs/bootstrap/bootstrap',
        Bootbox: '../js/libs/bootstrap/bootbox',
        Angular: '../js/libs/angular/angular',
        AngularCookies: '../js/libs/angular/angular-cookies',
        AngularUiRouter: '../js/libs/angular/angular-ui-router',
        AngularResource: '../js/libs/angular/angular-resource',
        AngularXEditable: '../js/libs/angular/xeditable',
        Lodash: '../js/libs/lodash/lodash',
        App: '../js/app/module'
    },
    priority: [
        'jQuery',
        'Angular',
        'AngularCookies',
        'AngularUiRouter',
        'AngularResource',
        'AngularXEditable',
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
        AngularCookies: ['Angular'],
        AngularResource: ['Angular'],
        AngularXEditable: ['Angular']
    }
});

require([
    'jQuery',
    'Bootstrap',
    'Bootbox',
    'Angular',
    'AngularCookies',
    'AngularUiRouter',
    'AngularResource',
    'AngularXEditable',
    'Lodash',
    'App'
], function () {

});
'use strict'

angular.module('app.services', ['ngResource'])

.factory('QuoteService', function($resource) {
	return $resource('/api/quote/:id', {id:'@_id'}, {
		random: {
			method: 'GET',
			url: '/api/quote/random'
		}
	});
});

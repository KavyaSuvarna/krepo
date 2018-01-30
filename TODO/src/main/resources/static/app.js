'use strict';

angular.module("todoApp", [])

.controller('todoController', ['$scope', '$http', function($scope, $http) {
	$scope.tasks = [];
	
	 $http({
	      method : "GET",
	      url : 'http://localhost:8080/todo/getAll'
	  }).then(function success(response) {
      	$scope.tasks = response.data;
      }, function error(reason) {
        // do something
      });
	 
	    $scope.addTask = function() { 
	        $http.get('http://localhost:8080/todo/addTask/'+$scope.newTask)
	        .then(function success(response) {
	        	$scope.tasks = response.data;
	        	delete $scope.newTask;
	        }, function error(reason) {
	          // do something
	        })
	    };
 
	 $scope.deleteTask = function(taskId){
		 $http({
		      method : "GET",
		      url : 'http://localhost:8080/todo/deleteTask/'+taskId
		  }).then(function success(response) {
	        	$scope.tasks = response.data;
	        	alert("Deleting Task");
	        }, function error(reason) {
	          // do something
          })
        };
	 
	 $scope.taskComplete = function(taskId){
		 $http({
		      method : "GET",
		      url : 'http://localhost:8080/todo/completeTask/'+taskId
		  }).then(function success(response) {
			  alert("Task Completed");
	        }, function error(reason) {
	          // do something
          })
        };
	 
	  $scope.pendingTasks = function(){
		  $http({
		      method : "GET",
		      url : 'http://localhost:8080/todo/getPendingTasks'
		  }).then(function success(response) {
	        	$scope.tasks = response.data;
	        }, function error(reason) {
	          // do something
          })
        };
        
	  $scope.completedTasks = function(){
		  $http({
		      method : "GET",
		      url : 'http://localhost:8080/todo/getCompletedTasks'
		  }).then(function success(response) {
	        	$scope.tasks = response.data;
	        }, function error(reason) {
	          // do something
          })
        };
	  
	  $scope.allTasks = function(){
		  $http({
		      method : "GET",
		      url : 'http://localhost:8080/todo/getAll'
		  }).then(function success(response) {
	        	$scope.tasks = response.data;
	        }, function error(reason) {
	          // do something
	        })
        };
	  
}]);

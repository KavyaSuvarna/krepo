'use strict';

angular.module("todoApp", [])

.controller('todoController', ['$scope', '$http', function($scope, $http) {
	 $http({
	      method : "GET",
	      url : 'http://localhost:8080/todo'
	  }).then(function mySuccess(response) {
		 
	  });
	  
	  $scope.addTask = function() {
	    
	    $http({
	      method : "GET",
	      url : 'http://localhost:8080/todo/addTask/'+$scope.newTask
	      
	  }).then(function mySuccess(response) {
		  delete $scope.newTask;
		  var json_response = @Html.Raw(Json.Encode(Model));
		  alert(json_response);
		  
	  })};
 
	 $scope.deleteTask = function(taskId){
		 $http({
		      method : "GET",
		      url : 'http://localhost:8080/todo/deleteTask/'+taskId
		  }).then(function mySuccess(response) {
		      
		  })};
	 
	 $scope.taskComplete = function(taskId){
		 $http({
		      method : "GET",
		      url : 'http://localhost:8080/todo/completeTask/'+taskId
		  }).then(function mySuccess(response) {
		      
		  })};
	 
	  $scope.pendingTasks = function(){
		  $http({
		      method : "GET",
		      url : 'http://localhost:8080/todo/getPendingTasks'
		  }).then(function mySuccess(response) {
		      
		  })};

	  $scope.completedTasks = function(){
		  $http({
		      method : "GET",
		      url : 'http://localhost:8080/todo/getCompletedTasks'
		  }).then(function mySuccess(response) {
		      
		  })};
	  
	  $scope.allTasks = function(){
		  $http({
		      method : "GET",
		      url : 'http://localhost:8080/todo'
		  }).then(function mySuccess(response) {
		      
		  })};
	  
	  
}]);

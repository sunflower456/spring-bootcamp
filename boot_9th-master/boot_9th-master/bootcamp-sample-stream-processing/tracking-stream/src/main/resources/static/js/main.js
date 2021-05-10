'use strict';

var messageArea = document.querySelector('#messageArea');
var statusArea = document.querySelector('#statusArea');

var stompClient = null;

function connect() {
    //
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, onConnected, onError);
}

function onConnected() {
    //
    stompClient.subscribe('/topic/public', onMessageReceived);
}

function onError(error) {
    //
    statusArea.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    statusArea.style.color = 'red';
}

function onMessageReceived(payload) {
    //
    var message = JSON.parse(payload.body);
    messageArea.innerText = message.content;
}

connect();

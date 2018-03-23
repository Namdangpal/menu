<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title></title>
  <script src="https://cdn.jsdelivr.net/npm/vue"></script>
  
</head>
<body>
  
  <div id="app">
    <h1>Hello, {{ name }}</h1>
  </div>
  
  <div id="app-2">
  <span v-bind:title="message">
    �� ���� ��� ���콺�� �ø��� �������� ���ε� �� title�� �� �� �ֽ��ϴ�!
  </span>
</div>

<div id="app-3">
  <p v-if="seen">���� ���� �� �� �־��</p>
</div>

<div id="app-4">
  <ol>
    <li v-for="todo in todos">
      {{ todo.text }}
    </li>
  </ol>
</div>
<div id="app-5">
  <p>{{ message }}</p>
  <button v-on:click="reverseMessage">�޽��� ������</button>
</div>
  <script>
var app = new Vue({
    el: '#app', // � ������Ʈ�� ������ �� �� ���մϴ�
    // data �� �ش� �信�� ����� ������ ���մϴ�
    data: {
      name: '��~~��~~~~�� Vue!!!!'
    }   
  });
  
var app2 = new Vue({
	  el: '#app-2',
	  data: {
	    message: '�� �������� ' + new Date() + ' �� �ε� �Ǿ����ϴ�'
	  }
	});
var app3 = new Vue({
	  el: '#app-3',
	  data: {
	    seen: true
	  }
	});
var app4 = new Vue({
	  el: '#app-4',
	  data: {
	    todos: [
	      { text: 'JavaScript ����' },
	      { text: 'Vue ����' },
	      { text: '���� ���� ���� �����' }
	    ]
	  }
	});
var app5 = new Vue({
	  el: '#app-5',
	  data: {
	    message: '�ȳ��ϼ���! Vue.js!'
	  },
	  methods: {
	    reverseMessage: function () {
	    this.message = this.message.split('').reverse().join('')
	    }
	  }
	});

</script>
  
</body>
</html>
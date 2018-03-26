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
    내 위에 잠시 마우스를 올리면 동적으로 바인딩 된 title을 볼 수 있습니다!
  </span>
</div>

<div id="app-3">
  <p v-if="seen">이제 나를 볼 수 있어요</p>
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
  <button v-on:click="reverseMessage">메시지 뒤집기</button>
</div>
<div id="app-6">
  <p>{{ message }}</p>
  <input v-model="message">
</div>

<div id="app-7">
  <ol>
    <!-- 
      이제 각 todo-item 에 todo 객체를 제공합니다.
      화면에 나오므로, 각 항목의 컨텐츠는 동적으로 바뀔 수 있습니다. 
      또한 각 구성 요소에 "키"를 제공해야합니다 (나중에 설명 됨).
     -->
    <todo-item
      v-for="item in groceryList"
      v-bind:todo="item"
      v-bind:key="item.id">
    </todo-item>
  </ol>
</div>

  <script>
var app = new Vue({
    el: '#app', // 어떤 엘리먼트에 적용을 할 지 정합니다
    // data 는 해당 뷰에서 사용할 정보를 지닙니다
    data: {
      name: '가~~쯔~~~~아 Vue!!!!'
    }   
  });
  
var app2 = new Vue({
	  el: '#app-2',
	  data: {
	    message: '이 페이지는 ' + new Date() + ' 에 로드 되었습니다'
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
	      { text: 'JavaScript 배우기' },
	      { text: 'Vue 배우기' },
	      { text: '무언가 멋진 것을 만들기' }
	    ]
	  }
	});
var app5 = new Vue({
	  el: '#app-5',
	  data: {
	    message: '안녕하세요! Vue.js!'
	  },
	  methods: {
	    reverseMessage: function () {
	    this.message = this.message.split('').reverse().join('')
	    }
	  }
	});
var app6 = new Vue({
	  el: '#app-6',
	  data: {
	    message: '안녕하세요 Vue!'
	  }
	});
Vue.component('todo-item', {
	  // 이제 todo-item 컴포넌트는 "prop" 이라고 하는
	  // 사용자 정의 속성 같은 것을 입력받을 수 있습니다.
	  // 이 prop은 todo라는 이름으로 정의했습니다.
	  props: ['todo'],
	  template: '<li>{{ todo.text }}</li>'
	})
	
var app7 = new Vue({
  el: '#app-7',
  data: {
    groceryList: [
      { id: 0, text: 'Vegetables' },
      { id: 1, text: 'Cheese' },
      { id: 2, text: 'Whatever else humans are supposed to eat' }
    ]
  }
,
created: function () {
  // `this` 는 vm 인스턴스를 가리킵니다.
  console.log('a is:아무튼생성')
}
});

</script>
  
</body>
</html>
import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      // ...currentUser,
      // username: (currentUser && currentUser.username) || '',
      // users: [
      //   {name: "Player1", score: 56, handicap: 8, course: "course1"},
      //   {name: "Ben Hoffman", score: 19, handicap: 7, course: "course2"},
      //   {name: "Meg Lemon", score: 42, handicap: 6, course: "course3"},
      // ],
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
    },
  });
  return store;


}

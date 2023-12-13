<template>
  <div id="login" class="login">

    <form v-on:submit.prevent="login">
      <h1>Yinzer Sign In</h1>

      <div class="alert" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>

      <div class="alert" role="alert" v-if="this.$route.query.registration">
        Thank yinz for registering! Sign in.
      </div>

      <div class="form-input-group">
        <label for="username">yinzer name</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>

      <div class="form-input-group">
        <label for="password">yinzer password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>

      <button class="submitBtn" type="submit">yinzer sign in</button>

      <p>
        <router-link class="sign-up-link" v-bind:to="{ name: 'register' }">new yinzer sign up</router-link>
      </p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            // let userId = response.data;
            // userId = 3; //this is hardcoded, use line above to get real number
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push(`/home`);
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}

form {
  height: auto;
  width: 18rem;
  border-radius: 15px;
  background-image: url("..\assets\Tee Time N'At (Ya JAG)_3.png");
  padding: 1rem;
  opacity: .85;
  display: flexbox;
  position: sticky;
}

.login {
  justify-content: center;
  align-items: center;
  display: flex;
  background-image: url("../assets/goldenGolf.jpeg");
  background-color: #312917;
  height: 100vh;
  background-size: cover;
  background-position: center;
  display: flexbox;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  font-family: 'Hedvig Letters Serif', serif;
  color: #093708;
  font-weight: 600;
}

input {
  flex-grow: 1;
  justify-items: center;
  align-self: center;
  width: 85%;
  margin: 5px;
}

h1 {
  text-align: center;
  justify-self: center;
  flex-grow: 1;
  font-size: 2em;
  font-weight: 700;
}

label {
  font-size: 1.25em;
}

.submitBtn {
  display: flex;
  text-align: center;
  margin: auto;
  font-size: 1em;
  background-color: #093708;
  font-weight: 600;
  font-family: 'Hedvig Letters Serif', serif;
  color: darkkhaki;
}

.submitBtn:hover {
  background-color: #116110;
  color: wheat;
}

p {
  text-align: center;
  padding-top: 15px;
}

.sign-up-link {
  color: darkkhaki;
}

.sign-up-link:hover {
  color: #116110;
  text-decoration-line: underline;
}

.alert {
  text-align: center;
  font-size: .75rem;
  padding: .5rem;
}
</style>

<template>

  <div id="login" class="login">
    <form v-on:submit.prevent="login">
      <h1 >Please Sign In</h1>

      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>

      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>

      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>

      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>

      <button class="submitBtn" type="submit">Sign in</button>
      
      <p>
      <router-link class="sign-up-link" v-bind:to="{ name: 'register' }">New User</router-link>
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
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
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
  height: 300px;
  width: 300px;
  border-radius: 15px;
  background-image: url("..\assets\Tee Time N'At (Ya JAG)_3.png");
  padding: 10px;
  border: 2px solid #f6f2f2;
  opacity: .45;
  display: flexbox;
  position: sticky;
}

.login {
  justify-content: center;
  align-items: center;
  display: flex;
  background-image: url("../assets/goldenGolf.jpeg");
  height: 100vh;
  background-size: 100%;
  background-repeat: no-repeat;
  background-position: center;
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
  background-color: #071e06;
  font-weight: 600;
  font-family: 'Hedvig Letters Serif', serif;
  color: darkkhaki;
  
}


p {
  text-align: center;
  padding-top: 15px;
}

.sign-up-link{
  color: rgb(128, 124, 66);
}


</style>
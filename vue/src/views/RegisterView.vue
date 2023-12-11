<template>
  <div id="register" class="register">
    <form v-on:submit.prevent="register">
      <h1>New Yinzer Golfer</h1>
      <div class="alert" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">yinzer name</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">yinzer password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">confirm password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <div class="form-input-group">
        <label for="firstName">first name</label>
        <input type="text" id="firstName" v-model="user.firstName" required />
      </div>
      <div class="form-input-group">
        <label for="lastName">last name</label>
        <input type="text" id="lastName" v-model="user.lastName" required />
      </div>
      <div class="form-input-group">
        <label for="email">email</label>
        <input type="email" id="email" v-model="user.email" required />
      </div>
      <button class="submitBtn" type="submit">create yinzer account</button>
      <p><router-link class="sign-in-link" v-bind:to="{ name: 'login' }">already a yinzer? go here.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        firstName: '',
        lastName: '',
        email: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
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
  width: 22rem;
  border-radius: 15px;
  background-image: url("..\assets\Tee Time N'At (Ya JAG)_3.png");
  background-repeat: no-repeat;
  background-color: white;
  padding: 1rem;
  opacity: .85;
  display: flexbox;
  position: sticky;
}

.register {
  justify-content: center;
  align-items: center;
  display: flex;
  background-image: url("../assets/goldenGolf.jpeg");
  background-color: #312917;
  height: 100vh;
  background-size: cover;
  background-position: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  text-align: center;
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

p {
  text-align: center;
  padding-top: 15px;
}

.sign-in-link{
  color: rgb(128, 124, 66);
}

.alert {
  text-align: center;
  font-size: .75rem;
  padding: .5rem;
}


</style>

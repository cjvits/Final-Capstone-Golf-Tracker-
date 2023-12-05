  <!-- TODO: Insert Logo
  TODO: Register <button></button>
  TODO: Search for courses by location search bar
    - should pop out a map when used 
  TODO: Login button in nav
-->

<template>
  <div>
    <p>Welcome {{ name }}</p>
    <p>The time is {{ dateTime }}</p>
  </div>
</template>
<script>
export default {
  name: "App",
  data() {
    return {
      name: "",
      dateTime: new Date(),
      timer: undefined,
      submitted: false,
    };
  },
  methods: {
    setDate() {
      this.dateTime = new Date();
    },
  },
  mounted() {
    this.timer = setInterval(() => {
      this.setDate();
    }, 1000);
  },
  beforeUnmount() {
    clearInterval(this.timer);
  },
};
</script>
<template>
    <div class="admin-page-container" v-if="this.$store.state.user.authorities.some((obj) => obj.name === 'ROLE_ADMIN')" >
        <h2 class="header">Administrator Page</h2>
        <NewCourseForm></NewCourseForm>
    </div>
    <div>
        
    </div>
</template>

<script>
    import NewCourseForm from '../components/NewCourseForm.vue';

    export default {

        computed: {
            
        },

        components: {
            NewCourseForm,
        },

        methods: {
            navigateToAdminPage(){
            if (this.$store.state.user.authorities.some((obj) => obj.name != 'ROLE_ADMIN')) {
                        this.$router.push('/access-denied');
            }
            

        }

    }
}

    
</script>

<style scoped>

.admin-page-container {
    background-color: darkkhaki;
    padding-top: 1%;
        background-image: url("../assets/goldenGolf.jpeg");
        background-color: #312917;
        height: 100vh;
        background-size: 100%;
        background-repeat: no-repeat;
        
        font-family: 'Hedvig Letters Serif', serif;
        color: #06612f;
        font-weight: 600;
        
    
}

.header {
        padding: 30px;
        text-align: center;
        font-size: 35px;
    }

</style>
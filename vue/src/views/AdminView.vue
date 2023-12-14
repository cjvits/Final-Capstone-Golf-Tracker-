<template>
    <div class="admin-page-container" v-if="this.$store.state.user.authorities.some((obj) => obj.name === 'ROLE_ADMIN')" >
        Administrator Page
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
}

</style>
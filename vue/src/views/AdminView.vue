<template>
    <div class="admin-page-container">
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

    }
</script>

<style scoped>

.admin-page-container {
    background-color: darkkhaki;
}

</style>
<template>
    <div class="admin-page-container">
        hello from admin page!
    </div>
    <div>
        <NewCourseForm></NewCourseForm>
    </div>
</template>

<script>
    import NewCourseForm from '../components/NewCourseForm.vue';

    export default {

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
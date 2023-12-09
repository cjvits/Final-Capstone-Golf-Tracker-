<template>
    <div>
        <form class="new-course-maker" v-on:submit.prevent="createNewCourse">
            <h1>Create a New Course</h1>

            <!--courseName: '',
                streetAddress: '',
                city: '',
                state: '',
                zipCode: 0,-->
            <div class="form-input-group">
                <label for="course-name">New Course Name</label>
                <input type="text" id="course-name" v-model="course.courseName" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="street-address">New Street Address Name</label>
                <input type="text" id="street-address" v-model="course.streetAddress" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="city-name">New City Name</label>
                <input type="text" id="city-name" v-model="course.cityName" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="state-name">New State Name</label>
                <input type="text" id="state-name" v-model="course.stateName" required autofocus />
            </div>

            <div class="form-input-group">
                <label for="zip-code">New ZipCode</label>
                <input type="text" id="zip-code" v-model="course.zipCode" required autofocus />
            </div>

            <button class="submitBtn" type="submit">create new course</button>
        </form>
    </div>
</template>


<script>
import CourseService from '../services/CourseService.js'

export default {
    data () {
        return {
            course: {
                courseName: '',
                streetAddress: '',
                city: '',
                state: '',
                zipCode: 0,
            }
        }
    },

    methods: {
        createNewCourse() {
            CourseService
            .createCourse(this.course)
            .then((response) => {
                    if (response.status == 201) {
                        this.$router.push({
                            path: '/admin',
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
        created() {

        CourseService
            .getAllCourses()
            .then((response) => this.courses = response.data)
        }
}
</script>

<style scoped>
.new-course-maker {
    background-color: darkkhaki;
}
</style>
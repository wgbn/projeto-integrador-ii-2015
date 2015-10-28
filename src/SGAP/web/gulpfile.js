var gulp = require('gulp');
//var concat = require('gulp-concat');
//var minifyCss = require('gulp-minify-css');
var sourcemaps = require('gulp-sourcemaps');
//var uglify = require('gulp-uglify');
var sass = require('gulp-sass');

/*gulp.task('css-compress', function() {
    return gulp.src('./css/styles/*.css')
        .pipe(sourcemaps.init())
        .pipe(concat('styles.css'))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('./css'));
});
gulp.task('js-compress', function() {
    return gulp.src('./js/vivasalute-views/*.js')
        .pipe(sourcemaps.init())
        .pipe(concat('scripts.js'))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('./js'));
});
gulp.task('minify-css', function() {
    return gulp.src('./webcomponents/css/webcomponents.css')
        .pipe(sourcemaps.init())
        .pipe(minifyCss())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('./webcomponents'));
});
gulp.task('minify-js', function() {
    return gulp.src('./js/*.js')
        .pipe(uglify())
        .pipe(gulp.dest('./js/min'));
});*/
gulp.task('sass', function () {
    gulp.src('./template/scss/*.scss')
        .pipe(sass({outputStyle: 'compressed'}).on('error', sass.logError))
        .pipe(gulp.dest('./template/css'));
});

gulp.task('default', function() {
    //gulp.watch('./css/styles/*.css', ['css-compress']);
    //gulp.watch('./css/views/*.css', ['minify-css']);
    //gulp.watch('./js/vivasalute-views/*.js', ['js-compress']);
    gulp.watch('./template/scss/*.scss', ['sass']);
    //gulp.watch('./webcomponents/scss/*.scss', ['sass-comp']);
    //gulp.watch('./webcomponents/css/*.css', ['css-compress-comp']);
});
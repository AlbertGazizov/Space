$(function(){
    _.templateSettings = {
        interpolate: /\<\@\=(.+?)\@\>/gim,
        evaluate: /\<\@(.+?)\@\>/gim
    };
    $(DragableStories.init());
    /* Gives to get router as global variable */
    window.appRouter = new AppRouter();
    Backbone.history.start();
})

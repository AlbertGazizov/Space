var AppRouter = Backbone.Router.extend({

    routes: {
        "stories/new":    "newStory",
        "stories/:id":    "showStory"
    },

    showStory: function(id) {
        var story = new Story({id : id});
        var storyView = new StoryView({model: story});
        story.fetch();
        storyView.render();
    },

    newStory: function() {
        var story = new Story();
        var newStoryView = new NewStoryView({model: story});
        newStoryView.render();
    }

});
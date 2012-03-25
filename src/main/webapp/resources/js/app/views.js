/** Viewing and editing a story */
var StoryView = Backbone.View.extend({
    tagName : "li",
    el      : "#story-modal",
    template : _.template($("#StoryTemplate").html()),
    events : {
        'click .close'                    : 'closeStory',
        'dblclick .title'                 : 'editTitle',
        'dblclick .description'           : 'editDescription',
        'keypress input[name=title]'      : 'saveStory',
        'keypress input[name=description]': 'saveStory',
        'mouseover .title'                : 'showEditIcon'
    },
//    edit_story : function () {
//        var self = this;
//        $("#story-form").html(_.template($("#StoryForm").html())( {} ))
//        $("#story-form").modal("show");
//
//        // populate fields
//        $("#story-form #description").val(this.model.get("description"))
//        $("#story-form #color").val(this.model.get("color"))
//        $("#story-form").find("h2").html("Edit Story")
//
//        // save action
//        $("#story-form").find(".save").click(function () {
//            var data = {}
//            var form_data = $("#story-form form").serializeArray();
//            for (var i in form_data) {
//                data[form_data[i].name]=form_data[i].value;
//            }
//            self.model.set(data)
//            self.model.save(data);
//            $("#story-form").modal("hide");
//        })
//
//    },
    initialize: function () {
        this.model.bind('change', this.render, this);
    },
    render: function () {
        // TODO: The class template doesn't work there, investigate
        template = _.template($("#StoryTemplate").html());
        $("#story-modal").html(template(this.model.toJSON()));
        $("#story-modal").modal("show");

        return this;
    },
    closeStory: function() {
        window.appRouter.navigate();
    },
    editTitle: function() {
        $("#story-modal .title").hide();
        $("#story-modal input[name=title]").show();
    },
    editDescription: function() {
        $("#story-modal .description").hide();
        $("#story-modal textarea[name=description]").show();
    },
    saveStory: function(e) {
        if (e.keyCode == 13) {
            title = $("input[name=title]").val();
            description = $("textarea[name=description]").val();
            this.model.save({title: title, description: description});
            $("#story-modal .title").show();
            $("#story-modal input[name=title]").hide();
            $("#story-modal .description").show();
            $("#story-modal input[name=description]").hide();
        }
    },
    showEditIcon: function() {

    }
})

/** Creating a new story form */
var NewStoryView = Backbone.View.extend({
    el      : "#story-modal",
    template : _.template($("#NewStoryTemplate").html()),
    events : {
        'click .close' : 'closeStory',
        'submit .story-form' : 'saveStory'
    },
    render: function () {
        // TODO: The class template doesn't work there, investigate
        template = _.template($("#NewStoryTemplate").html());
        $("#story-modal").html(template(this.model.toJSON()));
        $("#story-modal").modal("show");

        return this;
    },
    closeStory: function() {
        window.appRouter.navigate();
    },
    saveStory: function() {
        title = $("input[name=title]").val();
        description = $("textarea[name=description]").val();
        this.model.set({title: title, description: description});
        this.model.save();
        $("#story-modal").modal("hide");
        this.closeStory();
        return false;
    }
})
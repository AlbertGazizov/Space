// Load the application once the DOM is ready, using `jQuery.ready`:
$(function(){

    $(DragableStories.init());

  //Backbone.emulateHTTP = true;

  // Story Model
  // ----------

  // Our basic **Story** model has `id`, `title`, `description` attributes.
  window.Story = Backbone.Model.extend({
    url: "api/stories",

    // Default attributes for the story.
    defaults: {
      title: "empty titile...",
      description: "empty description..."
    },

    // Ensure that each story created has `title`, `description`.
    initialize: function() {
      if (!this.get("title")) {
            this.set({"title": this.defaults.title});
      }
      if (!this.get("description")) {
        this.set({"description": this.defaults.description});
      }
      if (!this.get("description")) {
          this.set({"_method": this.defaults._method});
      }
    }

//      toJSON: function(){
//          json = {car : this.attributes};
//          return _.extend(json, {engine_attributes: this.get("engine").toJSON());
//      }


  });

  // Story Collection
  // ---------------

  // The collection of story is backed by *localStorage* instead of a remote
  // server.
  window.StoryList = Backbone.Collection.extend({

    // Reference to this collection's model.
    model: Story,
    
    url: "api/stories"

  });

  // Create our global collection of **Stories**.
  window.Stories = new StoryList;

  // Story Item View
  // --------------

  // The DOM element for a story item...
  window.StoryView = Backbone.View.extend({

    //... is a list tag.
    tagName:  "li",

    // Cache the template function for a single item.
    template: _.template($('#item-template').html()),

    // The DOM events specific to an item.
    events: {
      "click .story-title"         : "showStory",
      "dblclick div.story-title"   : "edit",
      "click span.story-destroy"   : "clear",
      "keypress .story-input"      : "updateOnEnter"
    },

    // The StoryView listens for changes to its model, re-rendering. Since there's
    // a one-to-one correspondence between a **Story** and a **StoryView** in this
    // app, we set a direct reference on the model for convenience.
    initialize: function() {
      this.model.bind('change', this.render, this);
      this.model.bind('destroy', this.remove, this);
    },

    // Re-render the contents of the story item.
    render: function() {
      $(this.el).html(this.template(this.model.toJSON()));
      this.setTitle();
      return this;
    },

    // To avoid XSS (not that it would be harmful in this particular app),
    // we use `jQuery.text` to set the contents of the story item.
    setTitle: function() {
      var title = this.model.get('title');
      this.$('.story-title').text(title);
      this.input = this.$('.story-input');
      this.input.bind('blur', _.bind(this.close, this));
      this.input.val(title);
    },

    // Switch this view into `"editing"` mode, displaying the input field.
    edit: function() {
      $(this.el).addClass("editing");
      this.input.focus();
    },

    // Close the `"editing"` mode, saving changes to the story.
    close: function() {
      this.model.save({title: this.input.val()});
      $(this.el).removeClass("editing");
    },

    // If you hit `enter`, we're through editing the item.
    updateOnEnter: function(e) {
      if (e.keyCode == 13) this.close();
    },

    // Remove this view from the DOM.
    remove: function() {
      $(this.el).remove();
    },

    // Remove the item, destroy the model.
    clear: function() {
      this.model.destroy();
    },

    showStory: function() {
        $("#myModal").modal();
    }

  });

  // The Application
  // ---------------

  // Our overall **AppView** is the top-level piece of UI.
  window.AppView = Backbone.View.extend({

    // Instead of generating a new element, bind to the existing skeleton of
    // the App already present in the HTML.
    el: $("#storyapp"),

    // Delegated events for creating new items, and clearing completed ones.
    events: {
      "keypress #new-story":  "createOnEnter",
      "keyup #new-story":     "showTooltip"
    },

    // At initialization we bind to the relevant events on the `Stories`
    // collection, when items are added or changed. Kick things off by
    // loading any preexisting stories that might be saved in *localStorage*.
    initialize: function() {
      this.input    = this.$("#new-story");

      Stories.bind('add',   this.addOne, this);
      Stories.bind('reset', this.addAll, this);
      Stories.bind('all',   this.render, this);

      Stories.fetch();
    },

    // Add a single story item to the list by creating a view for it, and
    // appending its element to the `<ul>`.
    addOne: function(story) {
      var view = new StoryView({model: story});
      this.$("#story-list").append(view.render().el);
    },

    // Add all items in the **Stories** collection at once.
    addAll: function() {
      Stories.each(this.addOne);
    },

    // Generate the attributes for a new Story item.
    newAttributes: function() {
      return {
        title: this.input.val()
      };
    },

    // If you hit return in the main input field, create new **Story** model,
    // persisting it to *localStorage*.
    createOnEnter: function(e) {
      if (e.keyCode != 13) return;
      Stories.create(this.newAttributes());
      this.input.val('');
    },

    // Lazily show the tooltip that tells you to press `enter` to save
    // a new story item, after one second.
    showTooltip: function(e) {
      var tooltip = this.$(".ui-tooltip-top");
      var val = this.input.val();
      tooltip.fadeOut();
      if (this.tooltipTimeout) clearTimeout(this.tooltipTimeout);
      if (val == '' || val == this.input.attr('placeholder')) return;
      var show = function(){ tooltip.show().fadeIn(); };
      this.tooltipTimeout = _.delay(show, 1000);
    }

  });

  // Finally, we kick things off by creating the **App**.
  window.App = new AppView;

});

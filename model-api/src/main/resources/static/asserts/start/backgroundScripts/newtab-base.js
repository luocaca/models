(function (e) {
  try {
    var t = false;
    function a() {
      var e = parseInt(localStorage.getItem("curTabActive")) || 0;
      $("#tabs").tabs({
        active: e,
        activate: function () {

          if (a === 0) {
            localStorage.setItem("curTabActive", 0);
          } else if (a == 1) {
            localStorage.setItem("curTabActive", 1);
          } else if (a == 2) {
            localStorage.setItem("curTabActive", 2);
          }
        }
      });
    }


    $(document).ready(function () {
      a();

      function t() {
        $(".nav_menu").css("max-height", document.body.clientHeight - 80 + "px");
      }
      t();
      e.addEventListener("resize", t);

      if (localStorage.getItem("shuffle_background") == "yes") {
        $("#shuffle_background").prop("checked", true);
        $("#shuffle_favorites").prop("checked", false);
      } else {
        $("#shuffle_background").prop("checked", false);
      }
      $("#shuffle_background").off("change");
      $("#shuffle_background").on("change", function () {
        if ($("#shuffle_background").is(":checked")) {
          localStorage.setItem("shuffle_background", "yes");
          $("#shuffle_favorites").prop("checked", false);
          localStorage.setItem("shuffle_favorites", "no");
        } else {
          localStorage.setItem("shuffle_background", "no");
        }
        //utils.localstorage2cookie();
      });
      if (localStorage.getItem("shuffle_favorites") == "yes") {
        $("#shuffle_favorites").prop("checked", true);
        $("#shuffle_background").prop("checked", false);
      } else {
        $("#shuffle_favorites").prop("checked", false);
      }
      $("#shuffle_favorites").off("change");
      $("#shuffle_favorites").on("change", function () {
        if ($("#shuffle_favorites").is(":checked")) {
          localStorage.setItem("shuffle_favorites", "yes");
          $("#shuffle_background").prop("checked", false);
          localStorage.setItem("shuffle_background", "no");
        } else {
          localStorage.setItem("shuffle_favorites", "no");
        }
        //utils.localstorage2cookie();
      });
      e.loadGlobalOptions = function () {
        //e.loadToDoList();
        e.loadCountDownModule(e);
        e.loadAutoHideModule(e);
        e.loadSnowModule(e);

        if (localStorage.getItem("enable_most_visited") == "no") {
          $(".most_visited").hide();
        } else {
          $(".most_visited").show();
        }
        $("#enable_most_visited").prop("checked", localStorage.getItem("enable_most_visited") === "yes");
        $("#enable_most_visited").off("change");
        $("#enable_most_visited").on("change", function () {
          if (!$("#enable_most_visited").is(":checked")) {
            $(".most_visited").fadeOut();
          } else {
            $(".most_visited").fadeIn();
          }
          localStorage.setItem("enable_most_visited", $("#enable_most_visited").is(":checked") ? "yes" : "no");
          chrome.runtime.sendMessage({
            changeOptions: utils.getGlobalOptions()
          });
          //utils.localstorage2cookie();
        });
        if (localStorage.getItem("enable_apps") == "no") {
          $(".apps").fadeOut();
        } else {
          $(".apps").fadeIn();
        }
        $("#enable_apps").prop("checked", localStorage.getItem("enable_apps") === "yes");
        $("#enable_apps").off("change");
        $("#enable_apps").on("change", function () {
          if (!$("#enable_apps").is(":checked")) {
            $(".apps").fadeOut();
          } else {
            $(".apps").fadeIn();
          }
          localStorage.setItem("enable_apps", $("#enable_apps").is(":checked") ? "yes" : "no");
          chrome.runtime.sendMessage({
            changeOptions: utils.getGlobalOptions()
          });
          //utils.localstorage2cookie();
        });
        if (localStorage.getItem("enable_share") == "no") {
          $(".share").fadeOut();
        } else {
          $(".share").fadeIn();
        }
        $("#enable_share").prop("checked", localStorage.getItem("enable_share") === "yes");
        $("#enable_share").off("change");
        $("#enable_share").on("change", function () {
          if (!$("#enable_share").is(":checked")) {
            $(".share").fadeOut();
          } else {
            $(".share").fadeIn();
          }
          localStorage.setItem("enable_share", $("#enable_share").is(":checked") ? "yes" : "no");
          chrome.runtime.sendMessage({
            changeOptions: utils.getGlobalOptions()
          });
          //utils.localstorage2cookie();
        });
        if (localStorage.getItem("enable_slideshow") == "no") {
          s();
        } else {
          o();
        }
        $("#enable_slideshow").prop("checked", localStorage.getItem("enable_slideshow") === "yes");
        $("#enable_slideshow").off("change");
        $("#enable_slideshow").on("change", function () {
          if (!$("#enable_slideshow").is(":checked")) {
            s();
          } else {
            var e = [];
            if (localStorage.getItem("mark_favor")) e = JSON.parse(localStorage.getItem("mark_favor"));
            if (localStorage.getItem("shuffle_background") == "no" && (localStorage.getItem("shuffle_favorites") == "no" || localStorage.getItem("shuffle_favorites") == "yes" && e.length <= 1)) {
              localStorage.setItem("shuffle_background", "yes");
              localStorage.setItem("shuffle_favorites", "no");
              $("#shuffle_background").prop("checked", true);
              $("#shuffle_favorites").prop("checked", false);
            }
            o();
          }
          localStorage.setItem("enable_slideshow", $("#enable_slideshow").is(":checked") ? "yes" : "no");
          chrome.runtime.sendMessage({
            changeOptions: utils.getGlobalOptions()
          });

        });

        $('[data-toggle="tooltip"]').tooltip();
      };
      e.loadGlobalOptions();
      e.loadImagesInOption = function () {
        var t = 5;
        for (var a = 0; a < user["bg_img_list"]; a++) {
          var l = "bg-" + ("0" + a).slice(-2);
          var i = $("<li>");
          var o;
          var s;
          // if (Object.keys(user["bg_color_gif"]).indexOf(l + ".gif") > -1) {
          //   s = l + ".gif";
          //   o = $("<img>", {
          //     "data-src": s,
          //     src: utils.getExtensionURL("/start/content/images/" + l + ".gif")
          //   });
          // } else {
          s = l + ".jpg";
          o = $("<img>", {
            "data-src": s,
            src: utils.getExtensionURL(e.imageBuffer[a].fullPath)
          });
          //}
          i.append(o);
          // var n = '<div class="like-container" style="display: none;"><div class="like-action" data-src="' + s + '"></div><span class="like-label"></span></div>';
          // i.append(n);
          $("#images_selector").append(i);
          var c, g = [];
          if (localStorage.getItem("mark_favor")) g = JSON.parse(localStorage.getItem("mark_favor"));
          if (g.indexOf(a + "") > -1) {
            c = $('<span class="mark_favor marked_favor" favor-for="' + a + '" data-toggle="tooltip" data-placement="bottom" title="Remove this image from favorites"><span class="glyphicon glyphicon-heart"></span></span>');
          } else {
            c = $('<span class="mark_favor" favor-for="' + a + '" data-toggle="tooltip" data-placement="bottom" title="Mark this image as favorite"><span class="glyphicon glyphicon-heart-empty"></span></span>');
          }
          utils.resetClickHandler(c, function () {
            var e = $(this).attr("favor-for");
            var t = [];
            if (localStorage.getItem("mark_favor")) t = JSON.parse(localStorage.getItem("mark_favor"));
            $(this).toggleClass("marked_favor");
            if ($(this).hasClass("marked_favor")) {
              $(this).attr("data-toggle", "tooltip");
              $(this).attr("data-placement", "bottom");
              $(this).attr("data-original-title", "Remove this image from favorites");
              $(this).tooltip();
              $(this).find(".glyphicon").removeClass("glyphicon-heart-empty");
              $(this).find(".glyphicon").addClass("glyphicon-heart");
              if (t.indexOf(e + "") == -1) {
                t.push(e + "");
              }
            } else {
              $(this).attr("data-toggle", "tooltip");
              $(this).attr("data-placement", "bottom");
              $(this).attr("data-original-title", "Mark this image as favorite");
              $(this).tooltip();
              $(this).find(".glyphicon").removeClass("glyphicon-heart");
              $(this).find(".glyphicon").addClass("glyphicon-heart-empty");
              if (t.indexOf(e + "") > -1) {
                t.splice(t.indexOf(e + ""), 1);
              }
            }
            localStorage.setItem("mark_favor", JSON.stringify(t));
            //utils.localstorage2cookie();
          });
          $("#images_selector").append(c);
          // stange because of start from zero
          if (a > 5 && a % 5 == 4) {
            $("#images_selector").append($("<br>"));
          }
        }
        $("#images_selector li").each(function () {
          if (($(this).find("img").attr("src") + "").indexOf(e.chosenRandomBG) > -1) {
            $(this).addClass("selected");
          }
        });
        String.prototype.toShortNumber = function () {
          var e = this.toString();
          var t = Number(e);
          if (!t || t === NaN) {
            var a = e.match(/\d+/g).toString();
            t = Number(a);
          }
          var l;
          if (t >= 1e9) {
            l = (Math.round(t / 1e7) / 100).toString() + "B";
          } else if (t >= 1e6) {
            l = (Math.round(t / 1e4) / 100).toString() + "M";
          } else if (t >= 1e3) {
            l = (Math.round(t / 10) / 100).toString() + "K";
          } else if (t < 1e3) {
            return t.toString();
          }
          return l;
        };
       
        $("#close_background_selector_widget").off("click");
        $("#close_background_selector_widget").on("click", function (e) {
          $("#background_selector_widget").fadeOut();
        });
        $("#background_selector_widget").off("click");
        $("#background_selector_widget").on("click", function (e) {
          e.stopPropagation();
        });
        var h = [];

        $("#background_selector_widget #tab-background li").off("click");
        $("#background_selector_widget #tab-background li").on("click", function (t) {
          t.preventDefault();
          t.stopPropagation();
          var a = $(this).parent("ul");

          $("#background_selector_widget li.selected").removeClass();
          $(this).addClass("selected");

          if ($(this).find("img").length > 0) {
            var i = $(this).find("img").attr("data-src");
            user["bg_img"] = i;
            user["bg_color"] = "";
            e.setBackgroundGIFOrJPG(i);
          } else if ($(this).attr("cl")) {
            var o = $(this).attr("cl");
            $("body").css({
              "background-image": "none",
              background: "#" + o
            });
            user["bg_img"] = "none";
            user["bg_color"] = "#" + o;
          }

        });
        $('[data-toggle="tooltip"]').tooltip();
      };
      chrome.extension.sendMessage({
        rateStatus: true
      }, function (e) {
        if (e === -1) {
          $("#click-Rate").hide();
        }
        if (e === 0) {
          $("#click-Rate").show();
        }
        if (e === 1) {
          $("#click-Rate").addClass(localStorage.getItem("highlight") || "highlight");
          $("#click-Rate").show();
        }
      });
      utils.resetClickHandler($("#click-Rate"), function () {
        $("#click-Rate").attr("class", ($("#click-Rate").attr("class") || "").replace(/highlight[a-z_-]*[ ]*/gi, ""));
        localStorage.setItem("rate_clicked", "yes");
        //utils.localstorage2cookie();

        $("#click-Rate").hide();
        localStorage.setItem("rate_clicked", "cws");
        chrome.extension.sendMessage("click-Rate");
      });

      utils.resetClickHandler($(".lnk_privacy"), function () {
        chrome.extension.sendMessage("click-Privacy");
      });

      utils.resetClickHandler($(".click-Fanpage"), function () {
        chrome.extension.sendMessage("click-Rate");
      });
      utils.resetClickHandler($(".click-ShareFB"), function () {
        chrome.extension.sendMessage("click-ShareFB");
      });
      utils.resetClickHandler($(".click-ShareGG"), function () {
        chrome.extension.sendMessage("click-ShareGG");
      });
      utils.resetClickHandler($(".click-ShareTW"), function () {
        chrome.extension.sendMessage("click-ShareTW");
      });
      utils.resetClickHandler($(".click-SharePI"), function () {
        chrome.extension.sendMessage("click-SharePI");
      });
      utils.resetClickHandler($(".click-ShareTU"), function () {
        chrome.extension.sendMessage("click-ShareTU");
      });
      utils.resetClickHandler($(".click-ShareVK"), function () {
        chrome.extension.sendMessage("click-ShareVK");
      });
      utils.resetClickHandler($("#tool_menu a"), function () {
        if ($(this).attr("id") == "mail-address-shower") return;
        chrome.extension.sendMessage({
          name: "click-Apps",
          data: $(this).text().replace(/[ ]*\([0-9]+\)[ ]*$/, "")
        });
      });
      $('[data-toggle="tooltip"]').tooltip();
    });
    e.addEventListener("load", function () {
      $("#__bg").fadeIn(350, function () {
        $("#wrapper").fadeIn(100, function () {
          if (localStorage.getItem("theme_clicked") !== "yes") {
            $("#background_selector_menu").css("font-family", "'neue-bold'");
            $("#background_selector_menu").addClass(localStorage.getItem("highlight") || "highlight");
          }
          var a = function () {
            $("#background_selector_menu").css("font-family", "'neue',Helvetica,Arial,sans-serif");
            $("#background_selector_menu").attr("class", ($("#background_selector_menu").attr("class") || "").replace(/highlight[a-z_-]*[ ]*/gi, ""));
            localStorage.setItem("theme_clicked", "yes");
            //utils.localstorage2cookie();
          };
          utils.resetClickHandler($("#background_selector_menu"), function (l) {
            l.preventDefault();
            l.stopPropagation();
            $("#background_selector_widget").fadeIn();
            chrome.extension.sendMessage("click-ChangeThemeMenu");
            a();
            if (!t) {
              t = true;
              e.loadImagesInOption();
              //e.loadRelativeApps();
            }
          });
        });
      });
    });
    var l = null;
    var i = 10;
    var o = function () {
      $("#selectTimer").parent().fadeIn();
      if (localStorage.getItem("slideshow_timer")) {
        i = parseInt(localStorage.getItem("slideshow_timer"));
        $("#selectTimer select").val(i);
      }
      $("#selectTimer select").off("change");
      $("#selectTimer select").on("change", function () {
        i = parseInt($(this).val());
        localStorage.setItem("slideshow_timer", i);
      });
      function t() {
        var t = new Date().getTime();
        var a = 0;
        if (localStorage.getItem("last_time_do_slide")) {
          a = parseInt(localStorage.getItem("last_time_do_slide"));
        }
        if (t - a >= i * 1e3) {
          localStorage.setItem("last_time_do_slide", t);
          if (window.imageBuffer)
            e.setNewTabBackground();
        }
      }
      if (e.listAllThreads.threadSlideshow) {
        e.listAllThreads.threadSlideshow.pause();
      }
      e.listAllThreads.threadSlideshow = {
        pause: function () {
          clearInterval(l);
        },
        resume: function () {
          t();
          clearInterval(l);
          l = setInterval(t, 999);
        }
      };
      e.listAllThreads.threadSlideshow.resume();
    };
    var s = function () {
      $("#selectTimer").parent().fadeOut();
      clearInterval(l);
      localStorage.removeItem("last_time_do_slide");
    };
  } catch (e) {
    console.log(e);
  }
})(this);
(function(e) {
  "use strict";
  var t = null;
  if (!SEARCH_ENGINES[localStorage["sengine"]]) {
    delete localStorage["sengine"];
  }
  if (localStorage["sengine"] == undefined) setTimeout(function() {
    trackStatusEvent("newtab");
  }, 3e3); else setTimeout(function() {
    trackStatusEvent("newtab");
  }, 1e3);
  function o(e, t) {
    var o = e;
    for (var a in t) {
      var i = t[a];
      var s = new RegExp("\\{" + a + "\\}", "gi");
      o = o.replace(s, i);
    }
    return o;
  }
  function a() {
    var a = document.querySelector("#search-input").value;
    if (a == "" || a == null) return;
    $("#search-suggestion-pad").remove();
    var i;
    var s = utils.locale;
    s = s.replace("_", "-");
    if (a.trim().length > 0 || t.SearchForm == null) {
      var n = t.SearchUrl;
      i = o(n, {
        searchTerms: encodeURIComponent(a),
        lang: s
      });
    } else {
      i = t.SearchForm;
    }
    utils.count("c.snt");
    utils.mark_time("act.snt");
    trackStatusEvent("search-" + t.ShortName, null, a, function() {
      try {
        var t = [];
        if (localStorage.getItem("se_txt")) t = ("" + localStorage.getItem("se_txt")).split("|");
        if (t.indexOf(a) < 0) {
          if (t.length >= 50) t.shift();
          t.push(a);
          localStorage.setItem("se_txt", t.join("|"));
        }
      } catch (t) {
        if (e.debug) console.log(t);
      }
      e.top.location.href = i;
    });
  }
  var i = "web";
  user["selected_cat"] = i;
  $(document).ready(function() {
    d();
    var o = $("#search-input");
    var s = [ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" ];
    var n = "4c48e554026a4c9e97b3b2dc8824b559";
    var r = $("#weather");
    var l = $("input[type=search]");
    var c = [];
    if (localStorage.getItem("hideLink")) c = JSON.parse(localStorage.getItem("hideLink"));
    var u = [];
    if (localStorage.getItem("hideApp")) {
      u = JSON.parse(localStorage.getItem("hideApp"));
    }
    function d() {
      $("#tool_menu").html(`\n        <div><a id="tool_myaccount"  href="https://myaccount.google.com/"><i class="icon_myaccount"></i>My Account</a><div class="closebtn" hide-app="https://myaccount.google.com/"></div></div>\n        <div><a id="tool_gmail"      href="https://mail.google.com/mail/"><i class="icon_gmail"></i>Gmail</a><div class="closebtn" hide-app="https://mail.google.com/mail/"></div></div>\n        <div><a id="tool_youtube"    href="https://www.youtube.com/"><i class="icon_youtube"></i>Youtube</a><div class="closebtn" hide-app="https://www.youtube.com/"></div></div>\n        <div><a id="tool_drive"      href="https://drive.google.com/"><i class="icon_drive"></i>Drive</a><div class="closebtn" hide-app="https://drive.google.com/"></div></div>\n        <div><a id="tool_documents"  href="https://docs.google.com/document/"><i class="icon_documents"></i>Docs</a><div class="closebtn" hide-app="https://docs.google.com/document/"></div></div>\n        <div><a id="tool_contacts"   href="https://contacts.google.com/"><i class="icon_contacts"></i>Contacts</a><div class="closebtn" hide-app="https://contacts.google.com/"></div></div>\n        <div><a id="tool_calendar"   href="https://calendar.google.com/"><i class="icon_calendar"></i>Calendar</a><div class="closebtn" hide-app="https://calendar.google.com/"></div></div>\n        <div><a id="tool_photos"     href="https://photos.google.com/"><i class="icon_photos"></i>Photos</a><div class="closebtn" hide-app="https://photos.google.com/"></div></div>\n        <div><a id="tool_news"       href="https://news.google.com/"><i class="icon_news"></i>News</a><div class="closebtn" hide-app="https://news.google.com/"></div></div>\n        <div><a id="tool_googleplus" href="https://plus.google.com/"><i class="icon_googleplus"></i>Google+</a><div class="closebtn" hide-app="https://plus.google.com/"></div></div>\n        <div><a id="tool_hangouts"   href="https://hangouts.google.com/"><i class="icon_hangouts"></i>Hangouts</a><div class="closebtn" hide-app="https://hangouts.google.com/"></div></div>\n        <div><a id="tool_googlemap"  href="https://maps.google.com/"><i class="icon_googlemap"></i>Google Maps</a><div class="closebtn" hide-app="https://maps.google.com/"></div></div>\n        <div><a id="tool_classroom"  href="https://classroom.google.com/"><i class="icon_classroom"></i>Google Classroom</a><div class="closebtn" hide-app="https://classroom.google.com/"></div></div>\n        <hr>\n        <div><a id="tool_facebook"   href="https://www.facebook.com/"><i class="icon_facebook"></i>Facebook</a><div class="closebtn" hide-app="https://www.facebook.com/"></div></div>\n        `);
      var e = [ "Gmail", "YouTube", "Drive", "Docs", "Contacts", "Photos", "Calendar", "Google+", "Hangouts", "Google Maps", "Google Classroom", "Google Search" ];
      function t(t) {
        for (var o = 0; o < e.length; o++) {
          if (e[o] === t || "Google " + e[o] === t) {
            return true;
          }
        }
        return false;
      }
      chrome.management.getAll(function(e) {
        var o = e.filter(function(e) {
          return typeof e.appLaunchUrl !== "undefined";
        });
        for (var a = 0; a < o.length; a++) {
          var i = o[a];
          if (t(i.name)) {
            continue;
          }
          var s = document.createElement("DIV");
          var n = document.createElement("A");
          var r = document.createElement("I");
          var l = document.createTextNode(i.name);
          var c = document.createElement("DIV");
          c.className = "closebtn";
          c.setAttribute("hide-app", "app:" + i.id);
          r.setAttribute("style", "background-image:url('" + i.icons[0].url + "');background-size:cover;");
          n.setAttribute("id", i.id);
          n.addEventListener("click", function() {
            chrome.management.launchApp(this.id);
          });
          n.appendChild(r);
          n.appendChild(l);
          s.appendChild(n);
          s.appendChild(c);
          document.getElementById("tool_menu").appendChild(s);
          if (localStorage.getItem("hideApp")) {
            if (JSON.parse(localStorage.getItem("hideApp")).length > 0) {
              f("tool_menu", "Apps");
            }
          }
        }
        if (localStorage.getItem("hideApp")) {
          u = JSON.parse(localStorage.getItem("hideApp"));
          u.forEach((e, t) => {
            $(`#tool_menu a[href='${e}']`).parent().hide();
          });
        }
        h();
      });
    }
    m();
    function m() {
      chrome.runtime.sendMessage({
        topSites: true
      }, function(t) {
        var o = 0;
        for (var a = 0; a < t.length; a++) {
          if (c.indexOf(t[a].url) >= 0) {
            continue;
          } else {
            if(a != 0)
              $("#topsites_menu").append($("<hr>"));

            $("#topsites_menu").append($('<div><a href="' + (e.vl ? user["firstRunLandingPage"] : t[a].url) + '"><i style="background-image:url(\'https://www.google.com/s2/favicons?domain=' + encodeURIComponent(t[a].url) + "');background-size:cover;\"></i>" + t[a].title + '</a><div class="closebtn" close-for="' + t[a].url + '"></div></div>'));
            o++;
            if (o >= 10) break;
          }
        }
        utils.resetClickHandler($("#topsites_menu a"), function(e) {
          chrome.extension.sendMessage("click-TopSites");
        });
        if (localStorage.getItem("hideLink")) {
          if (JSON.parse(localStorage.getItem("hideLink")).length > 0) {
            f("topsites_menu", "Links");
          }
        }
        h();
      });
    }
    function h() {
      utils.resetClickHandler($(".closebtn"), function() {
        if ($(this).attr("close-for")) {
          c.push($(this).attr("close-for"));
          localStorage.setItem("hideLink", JSON.stringify(c));
          //utils.localstorage2cookie();
          m();
          $("#msg").text("Link removed");
          p("mostVisited");
        } else if ($(this).attr("hide-app")) {
          u.push($(this).attr("hide-app"));
          $(this).parent().remove();
          localStorage.setItem("hideApp", JSON.stringify(u));
          //utils.localstorage2cookie();
          $("#msg").text("App removed");
          p("apps");
        }
      });
    }
    var g = null;
    function p(e) {
      v();
      if (localStorage.getItem("hideApp")) {
        if (JSON.parse(localStorage.getItem("hideApp")).length > 0) {
          f("tool_menu", "Apps");
        }
      }
      if (localStorage.getItem("hideLink")) {
        if (JSON.parse(localStorage.getItem("hideLink")).length > 0) {
          f("topsites_menu", "Links");
        }
      }
      $(".undo-box").removeClass("undo-box-hide");
      utils.resetClickHandler($("#undobtn"), function() {
        if (e === "mostVisited") {
          c.pop();
          localStorage.setItem("hideLink", JSON.stringify(c));
          //utils.localstorage2cookie();
          $("#topsites_menu").empty();
          m();
        } else if (e === "apps") {
          u.pop();
          localStorage.setItem("hideApp", JSON.stringify(u));
          //utils.localstorage2cookie();
          $("#tool_menu").empty();
          if (u.toString().indexOf("mail.google.com") < 0) {
            chrome.runtime.sendMessage(chrome.runtime.id, {
              type: "fetch_email_data"
            });
          }
          d();
        }
        $(".undo-box").addClass("undo-box-hide");
      });
      $("#close-undo-box-btn").off("click");
      $("#close-undo-box-btn").click(function() {
        $(".undo-box").addClass("undo-box-hide");
        $("#undobtn").off("click");
      });
      if (g) {
        $(".undo-box").hover(function() {
          clearTimeout(g);
        }, function() {
          v();
        });
      }
    }
    function f(e, t) {
      let o = $("<div>", {
        class: e + "_restore"
      });
      if ($(`.${e}_restore`).size() <= 0) {
        o.html(`<a class="${e + "_restoreBtn"}" restore-for = "${e}"><i class="restoreBtn"></i>Restore ${t}</a>`);
        $(`#${e}`).append("<hr>").append(o);
        $(`.${e + "_restoreBtn"}`).click(function() {
          $(`#${$(this).attr("restore-for")}`).empty();
          if ($(this).attr("restore-for") === "tool_menu") {
            localStorage.removeItem("hideApp");
            if (u.toString().indexOf("mail.google.com") < 0) {
              chrome.runtime.sendMessage(chrome.runtime.id, {
                type: "fetch_email_data"
              });
            }
            d();
          } else if ($(this).attr("restore-for") === "topsites_menu") {
            localStorage.removeItem("hideLink");
            c = [];
            m();
          }
        });
      }
    }
    function v(e) {
      if (g) {
        clearTimeout(g);
        g = null;
      }
      g = setTimeout(function() {
        $(".undo-box").addClass("undo-box-hide");
        $("#undobtn").off("click");
      }, 7e3);
      if (e) {
        clearTimeout(g);
      }
    }
    var _ = function() {
      $("#topsites_menu").fadeOut(200);
      $("#share_menu").fadeOut(200);
      $("#support_menu").fadeOut(200);
      $("#tool_menu").fadeOut(200);
    };
    $("nav").off("mouseleave");
    $("nav").on("mouseleave", _);
    $("footer").off("mouseleave");
    $("footer").on("mouseleave", _);
    $("#topsites_menu").hide();
    utils.resetMouseEnterHandler($("#lnk_topsites"), function(e) {
      e.stopPropagation();
      $("#topsites_menu").show(200);
      $("#share_menu").fadeOut(200);
      $("#support_menu").fadeOut(200);
      $("#tool_menu").fadeOut(200);
    });
    utils.resetClickHandler($("#lnk_topsites"), function(e) {
      e.stopPropagation();
      $("#topsites_menu").toggle(200);
      $("#share_menu").fadeOut(200);
      $("#support_menu").fadeOut(200);
      $("#tool_menu").fadeOut(200);
    });
    utils.resetMouseEnterHandler($("#topsites_menu"), function(e) {
      e.stopPropagation();
      $("#topsites_menu").off("mouseleave");
      $("#topsites_menu").on("mouseleave", _);
    });
    utils.resetClickHandler($("#topsites_menu"), function(e) {
      e.stopPropagation();
    });
    $("#share_menu").hide();
    utils.resetMouseEnterHandler($("#lnk_share"), function(e) {
      e.stopPropagation();
      $("#topsites_menu").fadeOut(200);
      $("#share_menu").show(200);
      $("#support_menu").fadeOut(200);
      $("#tool_menu").fadeOut(200);
    });
    utils.resetClickHandler($("#lnk_share"), function(e) {
      e.stopPropagation();
      $("#topsites_menu").fadeOut(200);
      $("#share_menu").toggle(200);
      $("#support_menu").fadeOut(200);
      $("#tool_menu").fadeOut(200);
    });
    utils.resetMouseEnterHandler($("#share_menu"), function(e) {
      e.stopPropagation();
      $("#share_menu").off("mouseleave");
      $("#share_menu").on("mouseleave", _);
    });
    utils.resetClickHandler($("#share_menu"), function(e) {
      e.stopPropagation();
      _();
    });
    $("#support_menu").hide();
    utils.resetMouseEnterHandler($("#lnk_support"), function(e) {
      e.stopPropagation();
      $("#topsites_menu").fadeOut(200);
      $("#share_menu").fadeOut(200);
      $("#support_menu").show(200);
      $("#tool_menu").fadeOut(200);
    });
    utils.resetClickHandler($("#lnk_support"), function(e) {
      e.stopPropagation();
      $("#topsites_menu").fadeOut(200);
      $("#share_menu").fadeOut(200);
      $("#support_menu").toggle(200);
      $("#tool_menu").fadeOut(200);
    });
    utils.resetMouseEnterHandler($("#support_menu"), function(e) {
      e.stopPropagation();
      $("#support_menu").off("mouseleave");
      $("#support_menu").on("mouseleave", _);
    });
    utils.resetClickHandler($("#support_menu"), function(e) {
      e.stopPropagation();
      _();
    });
    $("#tool_menu").hide();
    utils.resetMouseEnterHandler($("#lnk_tool"), function(e) {
      e.stopPropagation();
      $("#topsites_menu").fadeOut(200);
      $("#share_menu").fadeOut(200);
      $("#support_menu").fadeOut(200);
      $("#tool_menu").show(200);
    });
    utils.resetClickHandler($("#lnk_tool"), function(e) {
      e.stopPropagation();
      $("#topsites_menu").fadeOut(200);
      $("#share_menu").fadeOut(200);
      $("#support_menu").fadeOut(200);
      $("#tool_menu").toggle(200);
    });
    utils.resetMouseEnterHandler($("#tool_menu"), function(e) {
      e.stopPropagation();
      $("#tool_menu").off("mouseleave");
      $("#tool_menu").on("mouseleave", _);
    });
    utils.resetClickHandler($("#tool_menu"), function(e) {
      e.stopPropagation();
    });
    utils.resetClickHandler($(document), function() {
      _();
      $("#search-suggestion-pad").hide();
      if ($("#background_selector_widget").css("opacity") == 1) {
        $("#background_selector_widget").fadeOut();
      }
    });
    
    A();
    $(".widght .time").on("click", function() {
      A();
    });
    
    function A() {
      if (user["time_format"] == "12h") {
        user["time_format"] = "24h";
      } else {
        user["time_format"] = "12h";
      }
      T();
      
    }
   
    function  T() {
      var e = new Date();
      if (user["time_format"] == "12h") {
        var t = e.getHours() < 12 ? "AM" : "PM";
        $(".ampm").html(t);
        $(".ampm").css("display", "inline-block");
        var o = e.getHours();
        if (o == 0) o = 12; else if (o > 12) o = o - 12;
        $(".hour").html(o + ":" + ("0" + e.getMinutes()).slice(-2));
      } else {
        $(".hour").html(("0" + e.getHours()).slice(-2) + ":" + ("0" + e.getMinutes()).slice(-2));
        $(".ampm").css("display", "none");
      }
      $(".day").html(s[e.getDay()]);
      $(".num").html(user["date_format"].replace("{{m}}", e.getMonth() + 1).replace("{{d}}", e.getDate()).replace("{{y}}", e.getFullYear()));
    }
    var x = setInterval(T, 1e4);
    //var D = setTimeout(E, C);
    if (e.listAllThreads.threadSearchForm) {
      e.listAllThreads.threadSearchForm.pause();
    }
    e.listAllThreads.threadSearchForm = {
      pause: function() {
        clearInterval(x);
        //clearTimeout(D);
      },
      resume: function() {
        T();
        clearInterval(x);
        //clearTimeout(D);
        x = setInterval(T, 1e4);
        //D = setTimeout(E, C);
      }
    };
    var M = SEARCH_ENGINES;
    $("#search-button").click(H);
    o.keyup(function(e) {
      $("#search-suggestion-pad").css({
        direction: o.css("direction")
      });
      if (e.keyCode == 13 || e.which == 13) {
        H();
      }
    });
    function H() {
      if (i == "web" || o.val() == "") {
        return;
      }
      var a = M[user["sengine"]][i] + o.val();
      try {
        trackStatusEvent("search-" + t.ShortName, null, o.val(), function() {
          e.top.location.href = a;
        });
      } catch (e) {}
    }
    
    function L(e) {
      return e.replace(/(?:^|\s)\w/g, function(e) {
        return e.toUpperCase();
      });
    }
    function R(o) {
      if (new Date().getTime() - parseInt(localStorage["setting_geo"]) > 6e3) {
        delete localStorage["setting_geo"];
      }
      if (!localStorage["setting_geo"]) {
        user["sengine"] = o;
      }
      var a = SEARCH_ENGINES[o];
      t = a;
      if (a["Logo"]) {
        $("#search-engine-item-title").html('<img src="' + a["Logo"] + '"/>');
      } else if (o == "palikan" && !localStorage["dotdotdot"]) {
        $("#search-engine-item-title").html("...");
      } else {
        $("#search-engine-item-title").html(L(o));
      }
      try {
        if (e.autoSuggest != null) e.autoSuggest.setSuggestUrl(a["SuggestUrl"]);
      } catch (e) {}
      //utils.localstorage2cookie();
      $("#search-input").attr("placeholder", "Search" + " " + a["ShortName"]);
    }
    $("#search-input").focus();
    $("#search-engine-select").css("display", "inline-block");
    $("#search-input").addClass("custom");
    var P = localStorage["sengine"] || SEARCH_ENGINES_DEFAULT;
    if (typeof P != "undefined") {
      R(P);
    }
    $(this).click(function() {
      $("#search-engine-list").empty().hide();
      $("#search-engine-select").removeClass("active");
    });
    $("#search-engine-select").click(function() {
      var e = $("#search-engine-list");
      if (e.children().length > 0) {
        $("#search-engine-list").empty();
        $(this).removeClass("active");
        return;
      }
      for (var t in SEARCH_ENGINES_ORDER) {
        var o = SEARCH_ENGINES_ORDER[t];
        if (user["sengine"] != o) {
          G(o);
        } else if (o == "palikan" && !localStorage["dotdotdot"]) {
          G(o);
        }
      }
      $("#search-engine-list").show();
      $(this).addClass("active");
      return false;
    });
    
    function J() {
      var o = document.getElementById("search-input");
      var i = t.SuggestUrl;
      e.autoSuggest = new AutoSuggest(o, i, a);
    }
    function q() {
      var e = false;
      $("#search-button").click(function() {
        if (i != "web") return;
        if (!e) {
          e = true;
          a();
          setTimeout(function() {
            e = false;
          }, 1e3);
        }
      });
      $("#search-input").keyup(function(e) {
        if (i != "web") {
          return;
        }
        if (e.keyCode == 13 || e.which == 13) {
          a.call(this);
        }
      });
    }
    q();
    J();
    
    function U(e) {
      (function e(t) {
        var o = document.getElementById("mail-address-shower");
        if (o) {
          o.innerHTML = t;
        } else {
          (function e() {
            var o = document.createElement("DIV");
            var a = document.createElement("A");
            var i = document.createTextNode(t);
            a.setAttribute("id", "mail-address-shower");
            a.appendChild(i);
            o.appendChild(a);
            document.getElementById("tool_menu").insertBefore(o, document.getElementById("tool_menu").firstChild);
          })();
        }
      })(e.mailAddress);
      (function e(t) {
        var o = document.getElementById("mail-counter");
        if (o) {
          o.innerHTML = "(" + t + ")";
        } else {
          (function e() {
            var o = document.createElement("SPAN");
            var a = document.createTextNode("(" + t + ")");
            o.setAttribute("style", "margin-left:5px;");
            o.setAttribute("id", "mail-counter");
            o.appendChild(a);
            document.getElementById("tool_gmail").appendChild(o);
          })();
        }
      })(e.mailNums);
    }
    chrome.runtime.sendMessage(chrome.runtime.id, {
      type: "fetch_email_data"
    });
    chrome.runtime.onMessage.addListener(function(t, o, a) {
      if (e.debug) {
        if (e.debug) console.log("request: ", t);
        if (e.debug) console.log("sender: ", o);
      }
      if (t.refreshOptions) {
        e.loadGlobalOptions();
      }
      
      if (t.type === "gmail_info_fetched") {
        U(t.info);
      }
      if (t.pauseAllThreads) {
        var i = Object.keys(e.listAllThreads);
        for (var s = 0; s < i.length; s++) {
          var n = e.listAllThreads[i[s]];
          if (n && typeof n.pause == "function") n.pause();
        }
      }
      if (t.resumeAllThreads) {
        var i = Object.keys(e.listAllThreads);
        for (var s = 0; s < i.length; s++) {
          var n = e.listAllThreads[i[s]];
          if (n && typeof n.resume == "function") n.resume();
        }
      }
      
    });
  });
})(this);
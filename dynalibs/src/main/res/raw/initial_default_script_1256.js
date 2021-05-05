function r(data)
{
  return JSON.stringify(data);
}
function j(data)
{
  return JSON.parse(data);
}
function isDefined(data)
{
  return typeof data ==='undefined' && data ===null;
}
function initialLayout()
{
  var layout = {
  updatePolicy: {
    policy: "setContentView"
  },
  globals: {
    statusBarColor: "red"
  },
  children: [{
  type: "TextView",
  id: "tv",
  attributes: {
    layout_width: "match_parent",
    layout_height: "match_parent",
    gravity: "center",
    textSize: 20,
    textColor: "chroma/chroma('pink').darken().saturate(2).hex();",
    textContent: {
      textContentType: "text",
      "text": "Hello World"
    }
  }
}]};
return layout;
}
function callFor(data)
{
    Host.callback(r({action:"toast",message: "hi"}));
    var json = j(data);
    var ins = json.action;
    switch(ins)
    {
        case "initialLayout":
        {
            return r(initialLayout());
        }
    }
}
import React from "react";
import { Redirect } from "@docusaurus/router";
import useDocusaurusContext from "@docusaurus/useDocusaurusContext";

function Home() {
  const context = useDocusaurusContext();
  const { siteConfig = {} } = context;
  return <Redirect to={`/PuzzleDroid/docs`} />;
}

export default Home;

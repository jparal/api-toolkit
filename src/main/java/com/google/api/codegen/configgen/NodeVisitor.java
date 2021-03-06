/* Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.api.codegen.configgen;

import com.google.api.codegen.configgen.nodes.ConfigNode;
import com.google.api.codegen.configgen.nodes.NullConfigNode;
import com.google.api.tools.framework.util.Accepts;
import com.google.api.tools.framework.util.GenericVisitor;

/**
 * Base class for ConfigNode visitors, using GenericVisitor.
 *
 * <p>Implements the accept methods necessary to traverse a sequence of nodes. Child traversal is
 * dependent on the concrete visitor.
 */
public abstract class NodeVisitor extends GenericVisitor<ConfigNode> {
  protected NodeVisitor() {
    super(ConfigNode.class);
  }

  protected void defaultAccept(ConfigNode node) {
    visit(node.getNext());
  }

  @Accepts
  void accept(NullConfigNode node) {}
}
